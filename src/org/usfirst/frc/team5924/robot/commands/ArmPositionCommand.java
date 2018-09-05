package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmPositionCommand extends Command {
		private String armColor;
    public ArmPositionCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArmManipulator);
    	requires(Robot.kLEDManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kArmManipulator.checkButtonToggle();
    	Robot.kArmManipulator.printArmInfo();
    	Robot.kLEDManipulator.setArmColor(armColor);
    	
		if(Robot.oi.getFrontIntakeButton()){
			Robot.kArmManipulator.setArmPositionValue(RobotConstants.frontIntakePos);
			armColor = "Front Intake";
			
		} else if(Robot.oi.getFrontSwitchButton()){
			Robot.kArmManipulator.setArmPositionValue(RobotConstants.frontSwitchPos);
			armColor = "Front Switch";
			
		} else if(Robot.oi.getCenterButton()){
			Robot.kArmManipulator.setArmPositionValue(RobotConstants.centerPos);
			armColor = "Center";
			
		} else if(Robot.oi.getBackSwitchButton()){
			Robot.kArmManipulator.setArmPositionValue(RobotConstants.backSwitchPos);
			armColor = "Back Switch";
			
		} else if(Robot.oi.getBackIntakeButton()) {
			Robot.kArmManipulator.setArmPositionValue(RobotConstants.backIntakePos);
			armColor = "Back Intake";
			
		}
		
		/**if(Robot.oi.getCatapultLaunchSequenceFrontButton()) {
			
			Robot.kArmManipulator.resetFrontIntakePosition();
		} else if(Robot.oi.getCatapultLaunchSequenceBackButton()) {
			
			Robot.kArmManipulator.resetBackIntakePosition();
		}**/
		
		/**if(Robot.oi.getIntakeButton() && armPosition == "Front Intake") {
			Robot.kArmManipulator.resetFrontIntakePosition();
		} else if(Robot.oi.getIntakeButton() && armPosition == "Back Intake"){
			Robot.kArmManipulator.resetBackIntakePosition();
		}**/
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	 
    	//Robot.kArmManipulator.setArmPositionValue(RobotConstants.frontIntakePos);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//end();
    }
}
