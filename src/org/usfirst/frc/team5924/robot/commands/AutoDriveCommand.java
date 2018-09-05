package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveCommand extends Command {

	private double inches;
	
    public AutoDriveCommand(double inchesReq) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.kRobotDrive);
    	inches = inchesReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kRobotDrive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kRobotDrive.printAutoMotorInfo();
    	if(inches > 0) {
			if(Robot.kRobotDrive.getAverageEncoderPosition() < inches){
				Robot.kRobotDrive.moveRobot(0.6);

			}
    	} else if(inches < 0) {
    		if(Robot.kRobotDrive.getAverageEncoderPosition() > inches) {
    			Robot.kRobotDrive.moveRobot(-0.6);

    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.kRobotDrive.autoDriveFinish(inches);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}