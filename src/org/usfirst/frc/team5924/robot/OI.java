/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5924.robot;

import org.usfirst.frc.team5924.robot.commands.CatapultCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	
	public static Joystick xboxJoy = new Joystick(RobotConstants.cXboxJoy);
	public static Joystick buttonPanel = new Joystick(RobotConstants.cButtonPanel);

	public OI() {
		
	}
	
	public double getButtonPanelAxis() {
		
		return buttonPanel.getRawAxis(RobotConstants.cButtonPanelAxis);
		
	}
	
	public double getXboxYAxis() {
		
		return xboxJoy.getRawAxis(RobotConstants.cXboxJoyYAxis);
		
	}
	
	public double getXboxXAxis() {
		
		return xboxJoy.getRawAxis(RobotConstants.cXboxJoyXAxis);
		
	}
	
	public boolean getFrontIntakeButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.frontIntakePosButton);
		
	}
	
	public boolean getFrontSwitchButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.frontSwitchPosButton);
		
	}
	
	public boolean getCenterButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.centerPosButton);
		
	}
	
	public boolean getBackSwitchButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.backSwitchPosButton);
		
	}
	
	public boolean getBackIntakeButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.backIntakePosButton);
		
	}
	
	public boolean getIntakeButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.intakeCubeButton);
		
	}
	
	public boolean getOuttakeButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.outtakeCubeButton);
		
	}
	
	public boolean getCatapultLaunchSequenceFrontButton() {
		
		return buttonPanel.getRawButton(RobotConstants.catapultLaunchSequenceFrontButton);
		
	}
	
	public boolean getCatapultLaunchSequenceBackButton() {
		
		return buttonPanel.getRawButtonPressed(RobotConstants.catapultLaunchSequenceBackButton);
		
	}
}
