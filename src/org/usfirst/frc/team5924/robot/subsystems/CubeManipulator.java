package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.CubeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CubeManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotConstants.cCubeLeft); 
	private WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotConstants.cCubeRight);
	
	//private DigitalInput intakeLimitSwitch = new DigitalInput(RobotConstants.intakeLimitSwitch);
	
	private double cubeMotorSpeed = 0;
	
	private Timer intakeTimer = new Timer();
	private Timer outtakeTimer = new Timer();
	
	private String cubeStatus = "";
	
	public CubeManipulator(){
		
	}
	//PRINT CUBE INFO TO SMARTDASHBOARD
	public void printCubeInfo(){
		
		SmartDashboard.putString("Cube Status", cubeStatus);
		SmartDashboard.putNumber("Cube Left Motor", leftMotor.getMotorOutputVoltage());
		SmartDashboard.putNumber("Cube Right Motor", rightMotor.getMotorOutputVoltage());
		
	}
	//TELEOP STUFF
	public void runCubeMotor(){
		
		if(intakeTimer.get() > 0.5 && (leftMotor.getMotorOutputVoltage() < 7.1 || rightMotor.getMotorOutputVoltage() > -7.1)){
			
			intakeTimer.stop();
			intakeTimer.reset();
			cubeMotorSpeed = 0.0;
			cubeStatus = "Intake Done";
				
		} else if(outtakeTimer.get() > 0.5){
			
			outtakeTimer.stop();
			outtakeTimer.reset();
			cubeMotorSpeed = 0.0;
			cubeStatus = "Outtake Done";
		}

		leftMotor.set(-cubeMotorSpeed);
		rightMotor.set(cubeMotorSpeed);

	}
	
	public void intakeCube(){
		
		intakeTimer.start();
		cubeMotorSpeed = -0.7;
		cubeStatus = "Intake";
		
	}
	
	public void outtakeCube(){
		
		outtakeTimer.start();
		cubeMotorSpeed = 0.70;
		cubeStatus = "Outtake";
		
    }
	
	public void outtakeScaleCube() {
		
		outtakeTimer.start();
		cubeMotorSpeed = 1;
		cubeStatus = "Outtake Scale";
		
	}
	
	/**public void outtakeAutoCube() {
		
		outtakeTimer.start();
		cubeMotorSpeed = 0.4;
		cubeStatus = "Outtake";
				
	}**/
	
	public void stopCubeMotor() {
		
		cubeMotorSpeed = 0;
		
	}
	
	public boolean isIntakeSwitchClosed() {
		
		//return intakeLimitSwitch.get();
		return false;
		
	}
	//AUTO COMMAND CHECK
	public boolean checkCubeAuto(){
		
		if(cubeStatus == "Intake Done") {
			return true;
			
		} else if(cubeStatus == "Outtake Done"){
			return true;
		}
		return false;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new CubeCommand());
    }
}

