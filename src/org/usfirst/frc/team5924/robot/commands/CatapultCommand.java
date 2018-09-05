package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CatapultCommand extends Command {
	
	//String catapultType;
	
	//Timer timer = new Timer();

    public CatapultCommand(String catapultReq) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.kArmManipulator);
    	//requires(Robot.kCubeManipulator);
    	//catapultType = catapultReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/**if(catapultType == "Front") {
    		timer.start();
    		Robot.kArmManipulator.setArmPositionValue(RobotConstants.backIntakePos);
    		Robot.kCubeManipulator.runCubeMotor();
    		System.out.println(Robot.kArmManipulator.getArmTalonPosition());
    		if(Robot.kArmManipulator.getArmTalonPosition() > 2500) {
    			Robot.kCubeManipulator.outtakeCube();
    		}
    		catapultType = "";
    	} else if(catapultType == "Back") {
    		timer.start();
    		Robot.kArmManipulator.setArmPositionValue(RobotConstants.frontIntakePos);
    		Robot.kCubeManipulator.runCubeMotor();
    		if(timer.get() > 0.5) {
    			Robot.kCubeManipulator.outtakeCube();
    		}
    		catapultType = "";
    	} **/
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       // return Robot.kCubeManipulator.checkCubeAuto() || isTimedOut();
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
