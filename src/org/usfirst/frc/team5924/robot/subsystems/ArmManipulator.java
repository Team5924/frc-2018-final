package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.ArmPositionCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static WPI_TalonSRX armTalon = new WPI_TalonSRX(RobotConstants.cArm);
	double setArmPositionConfig = 3072;
	boolean buttonToggle = false;
	
	//private static DigitalInput frontLimitSwitch = new DigitalInput(RobotConstants.frontLimitSwitch);
	//private static DigitalInput backLimitSwitch = new DigitalInput(RobotConstants.backLimitSwitch);
	
	public ArmManipulator() {
		
		armTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		armTalon.setSensorPhase(true);
		armTalon.setInverted(false);
		armTalon.config_kP(0, 0.5, 10); //.9
		armTalon.config_kI(0, 0.0, 10); //0
		armTalon.config_kD(0, 0.00015, 10); //.00007
		armTalon.config_kF(0, 0, 10);
		armTalon.configForwardSoftLimitThreshold(6144, 0);
		armTalon.configForwardSoftLimitEnable(false, 0);
		armTalon.configReverseSoftLimitThreshold(0, 0);
		armTalon.configReverseSoftLimitEnable(false, 0);
		armTalon.setSelectedSensorPosition(0, 0, 0);
		
	}
	public void printArmInfo() {
		
		SmartDashboard.putNumber("Arm Encoder", armTalon.getSelectedSensorPosition(0));
		
	}
	
	public double getArmTalonPosition() {
		
		return armTalon.getSelectedSensorPosition(0);
		
	}
	
	public void setRawArmPosition() {
		
		armTalon.set(Robot.oi.getButtonPanelAxis() * 0.6);
		
	}
	
	public void setArmPositionValue(double setArmPosition) {

		setArmPositionConfig = setArmPosition;
		
	}
	
	public void setArmPosition() {
		
		armTalon.set(ControlMode.Position, setArmPositionConfig);
		
	}
	
	public void setArmAutoPosition(double armPositionReq) {
		
		armTalon.set(ControlMode.Position, armPositionReq);
		
	}
	
	public void resetFrontIntakePosition() {
			
		armTalon.setSelectedSensorPosition(0, 0, 0);
		
	}
	
	public void resetBackIntakePosition() {
		
		armTalon.setSelectedSensorPosition(6144, 0, 0);
		
	}
	
	public void checkButtonToggle(){
    	
    	if(Robot.oi.getButtonPanelAxis() != 0 && Robot.oi.getCatapultLaunchSequenceFrontButton()) {
    		setRawArmPosition();
    	} else{
    		setArmPosition();
    	}
	}
    	/**if((buttonToggle % 2) == 0){
    		
    		SmartDashboard.putString("Control Mode", "Position");
    		
    	} else {
    		setRawArmPosition();
    		SmartDashboard.putString("Control Mode", "Voltage");
    	}*/
	
	public boolean isFrontSwitchClosed() {
		
		//return frontLimitSwitch.get();
		return false;
		
	}
	
	public boolean isBackSwitchClosed() {
		
		//return backLimitSwitch.get();
		return false;
		
	}
	
	public boolean isArmPositionFinished(double armPositionReq) {
		if(Math.abs(armPositionReq - armTalon.getSelectedSensorPosition(0)) < 5) {
			return true;
		} else {
			return false;
		}
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArmPositionCommand());
    }
}

