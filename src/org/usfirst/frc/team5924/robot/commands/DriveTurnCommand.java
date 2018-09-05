package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnCommand extends Command { //FIX THIS
	
	private String turnType;
	private double degrees;
	
    public DriveTurnCommand(String turnReq, double degreesReq) {
        // Use requires() here to declare subsystem dependencies
    	//requires(Robot.kGyroTurning);
    	requires(Robot.kRobotDrive);
    	turnType = turnReq;
    	degrees = degreesReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.imu.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kRobotDrive.printAutoMotorInfo();
    	Robot.kRobotDrive.turnRobotDegrees(turnType, degrees);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kRobotDrive.turnFinish();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.kRobotDrive.stopRobot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//end();
    }
}