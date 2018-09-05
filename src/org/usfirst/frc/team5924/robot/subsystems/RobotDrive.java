package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.Robot;
import org.usfirst.frc.team5924.robot.RobotConstants;
import org.usfirst.frc.team5924.robot.commands.DriveCommand;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RobotDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotConstants.cFrontRight);
	public static WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotConstants.cRearRight);
	public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotConstants.cFrontLeft);
	public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotConstants.cRearLeft);
	
	public static SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, rearRight);
	public static SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, rearLeft);
	
	public static DifferentialDrive rDrive = new DifferentialDrive(rightSide, leftSide);

	public Encoder leftEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
	public Encoder rightEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	private static double distancePerPulse = 4 * (5.0 * Math.PI) / 1440.0;
	
	private String turnStatus = "";
	private double angleError;
	private double angle;
	private double errorFactor = 0.011;
	
	public RobotDrive(){
		//pulses per revolution: 1440
		//E4T MINI optical encoder
		rightEncoder.setDistancePerPulse(distancePerPulse);
		leftEncoder.setDistancePerPulse(distancePerPulse);	
		
	}
	//PRINT DRIVE INFO tO SMARTDASHBOARD
	public void printMotorInfo(){
		
		SmartDashboard.putNumber("Front Right Motor Voltage", frontRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Right Motor Voltage", rearRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Front Left Motor Voltage", frontLeft.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Left Motor Voltage", rearLeft.getMotorOutputVoltage());
	}
	//AUTO TESTING
	public void printAutoMotorInfo(){
		
		SmartDashboard.putNumber("Left Encoder Position", leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Encoder Position", rightEncoder.getDistance());
		SmartDashboard.putNumber("Z-Axis Angle", -Robot.imu.getAngleZ());
    	SmartDashboard.putString("Robot Turn Status", turnStatus);
	}
	//TELE STUFF
	public void driveRobotBase(){
		//angle = Robot.imu.getAngleZ();
		
		rDrive.arcadeDrive(Robot.oi.getXboxYAxis(), Robot.oi.getXboxXAxis());
	}
	//AUTO STUFF
	public void moveRobot(double robotSpeedReq){
		rDrive.arcadeDrive(-robotSpeedReq, 0);
	}
	
	public void stopRobot() {
		rDrive.arcadeDrive(0, 0);
	}
	//GYRO TURNING (IN PROGRESS) - need to tune turn
	/**public void turnRobot(String turnTypeReq){
		angle = Robot.imu.getAngleZ();
		angleError = targetAngle - Math.abs(angle);
		if(turnTypeReq == "R"){
	    	if(-Robot.imu.getAngleZ() < targetAngle){
	    		/**if(angleError >= 20){
	    			//Robot.kRobotDrive.rDrive.arcadeDrive(0, (angleError * errorFactor));
	    			rDrive.arcadeDrive(0, 0.6);
	    			turnStatus = "Turning Right";
	    		} else if(angleError < 20) {
	    			rDrive.arcadeDrive(0, 0.375);
	    		}
	    		rDrive.arcadeDrive(0, angleError * errorFactor);
	    	}
	    } else if(turnTypeReq == "L"){
			if(-Robot.imu.getAngleZ() > -targetAngle){
				/**if(angleError >= 20){
					//Robot.kRobotDrive.rDrive.arcadeDrive(0, (-angleError * errorFactor));
					rDrive.arcadeDrive(0, -0.6);
					turnStatus = "Turning Left";
	    		} else if(angleError < 20) {
	    			rDrive.arcadeDrive(0, -0.375);
	    		}
				rDrive.arcadeDrive(0, -angleError * errorFactor);
			}
	    }
	}**/
	
	public void turnRobotDegrees(String turnTypeReq, double degreesReq) {
		angle = Robot.imu.getAngleZ();
		angleError = degreesReq - Math.abs(angle);
		if(turnTypeReq == "R"){
	    	/**if(-Robot.imu.getAngleZ() < degreesReq){
	    		rDrive.arcadeDrive(0, angleError * errorFactor);
	    	}**/
			rDrive.arcadeDrive(0, 0.5);
	    } else if(turnTypeReq == "L"){
			/**if(-Robot.imu.getAngleZ() > -degreesReq){
				rDrive.arcadeDrive(0, -angleError * errorFactor);
			}**/
	    	rDrive.arcadeDrive(0, -0.5);
	    }
	}
	
	public double getAverageEncoderPosition() {
		
		//return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
		return leftEncoder.getDistance();
	}
	
	public void resetEncoders() {
		
		rightEncoder.reset();
		leftEncoder.reset();
	}
	//AUTO COMMAND CHECK
	public boolean autoDriveFinish(double inchesReq){
		
		if (Math.abs(Robot.kRobotDrive.getAverageEncoderPosition()) >= inchesReq){
			return true;
		}
		
		return false;
	}
	
	public boolean turnFinish(){
		if(Math.abs(angleError) < 1) {
			turnStatus = "Complete";
			return true;
		}
		
		return false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
}