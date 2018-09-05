package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LEDCommand extends Command {

	String armColor = "";
	String armPositionCheck = "";
	
    public LEDCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kLEDManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kLEDManipulator.setArmColor(armColor);
    	if(Robot.oi.getFrontIntakeButton()) {
    		armColor = "Front Intake";
    		armPositionCheck = "Front Intake";
    	} else if(Robot.oi.getFrontSwitchButton()) {
    		armColor = "Front Switch";
    		armPositionCheck = "Front Switch";
    	} else if(Robot.oi.getCenterButton()) {
    		armColor = "Center";
    	} else if(Robot.oi.getBackSwitchButton()) {
    		armColor = "Back Switch";
    		armPositionCheck = "Back";
    	} else if(Robot.oi.getBackIntakeButton()) {
    		armColor = "Back Intake";
    		armPositionCheck = "Back Intake";
    	} else if(Robot.oi.getIntakeButton() && armPositionCheck == "Front Intake") {
    		armColor = "Front Intake Intake";
    	} else if(Robot.oi.getOuttakeButton() && armPositionCheck == "Front Intake") {
    		armColor = "Front Intake Outtake";
    	} else if(Robot.oi.getOuttakeButton() && armPositionCheck == "Front Switch") {
    		armColor = "Front Switch Outtake";
    	} else if(Robot.oi.getIntakeButton() && armPositionCheck == "Back Intake") {
    		armColor = "Back Intake Intake";
    	} else if(Robot.oi.getOuttakeButton() && armPositionCheck == "Back Intake") {
    		armColor = "Back Intake Outtake";
    	} else if(Robot.oi.getOuttakeButton() && armPositionCheck == "Back Switch") {
    		armColor = "Back Switch Outtake";
    	} else if(Robot.oi.getCatapultLaunchSequenceFrontButton() && Robot.oi.getCatapultLaunchSequenceBackButton()) {
    		armColor = "Emergency";
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
