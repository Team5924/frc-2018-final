package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmPositionAutoCommand extends Command {
	
	double armPosition;

    public ArmPositionAutoCommand(double armPositionReq) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArmManipulator);
    	armPosition = armPositionReq;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {	
    	setTimeout(1);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kArmManipulator.printArmInfo();
    	Robot.kArmManipulator.setArmAutoPosition(armPosition);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kArmManipulator.isArmPositionFinished(armPosition)|| isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
