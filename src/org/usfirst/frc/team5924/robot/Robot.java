/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5924.robot;

import org.usfirst.frc.team5924.robot.commands.AutoCommand;
import org.usfirst.frc.team5924.robot.subsystems.ArmManipulator;
import org.usfirst.frc.team5924.robot.subsystems.CubeManipulator;
import org.usfirst.frc.team5924.robot.subsystems.LEDManipulator;
import org.usfirst.frc.team5924.robot.subsystems.RobotDrive;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ArmManipulator kArmManipulator = new ArmManipulator();
	public static final RobotDrive kRobotDrive = new RobotDrive();
	public static final CubeManipulator kCubeManipulator = new CubeManipulator();
	public static final LEDManipulator kLEDManipulator = new LEDManipulator();
	public static OI oi = new OI();
	public static final ADIS16448_IMU imu = new ADIS16448_IMU();

	DriverStation.Alliance allianceColor;
	String selectedString;
	String gameData;
	Command autoCommand;
	SendableChooser<String> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {	
		m_chooser.addDefault("Center Auto", "C");
		m_chooser.addObject("Right Auto", "R");
		m_chooser.addObject("Left Auto", "L");
		m_chooser.addObject("Basic Auto", "A");
		SmartDashboard.putData("Auto mode", m_chooser);
		
		imu.calibrate();
		
		//UsbCamera rampCam = CameraServer.getInstance().startAutomaticCapture();
		UsbCamera armCam = CameraServer.getInstance().startAutomaticCapture();
		//rampCam.setResolution(640, 480);
		armCam.setResolution(320, 240);
		armCam.setFPS(20);
	
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		selectedString = m_chooser.getSelected();
		allianceColor = DriverStation.getInstance().getAlliance();
		if(allianceColor == DriverStation.Alliance.Blue) {
			LEDManipulator.arduino6.set(true);
			LEDManipulator.arduino7.set(true);
			LEDManipulator.arduino8.set(false);
			LEDManipulator.arduino9.set(true);
		} else if(allianceColor == DriverStation.Alliance.Red) {
			LEDManipulator.arduino6.set(true);
			LEDManipulator.arduino7.set(true);
			LEDManipulator.arduino8.set(true);
			LEDManipulator.arduino9.set(true);
		}
		autoCommand = new AutoCommand(selectedString, gameData);
		// schedule the autonomous command (example)
		if (autoCommand != null) {
			autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null) {
			autoCommand.cancel();
		}			
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
