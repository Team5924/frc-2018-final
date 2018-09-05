package org.usfirst.frc.team5924.robot.subsystems;

import org.usfirst.frc.team5924.robot.commands.LEDCommand;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static DigitalOutput arduino6 = new DigitalOutput(6);
	public static DigitalOutput arduino7 = new DigitalOutput(7);
	public static DigitalOutput arduino8 = new DigitalOutput(8);
	public static DigitalOutput arduino9 = new DigitalOutput(9);

	public LEDManipulator() {
		arduino6.set(false);
		arduino7.set(false);
		arduino8.set(false);
		arduino9.set(false);
	}
	
	public void getString() {
		System.out.print("");
	}
	
	public void setArmColor(String armColorReq) {
		if(armColorReq == "Front Intake") {
			arduino6.set(true);
			arduino7.set(false);
			arduino8.set(false);
			arduino9.set(false);
		} else if(armColorReq == "Front Switch") {
			arduino6.set(false);
			arduino7.set(true);
			arduino8.set(false);
			arduino9.set(false);
		} else if(armColorReq == "Center") {
			arduino6.set(false);
			arduino7.set(false);
			arduino8.set(true);
			arduino9.set(false);
		} else if(armColorReq == "Back Switch") {
			arduino6.set(false);
			arduino7.set(false);
			arduino8.set(false);
			arduino9.set(true);
		} else if(armColorReq == "Back Intake") {
			arduino6.set(true);
			arduino7.set(true);
			arduino8.set(false);
			arduino9.set(false);
		} else if(armColorReq == "Front Intake Intake") {
			arduino6.set(true);
			arduino7.set(false);
			arduino8.set(true);
			arduino9.set(false);
		} else if(armColorReq == "Front Intake Outtake") {
			arduino6.set(false);
			arduino7.set(true);
			arduino8.set(false);
			arduino9.set(true);
			armColorReq = "Front Intake";
		} else if(armColorReq == "Front Switch Outtake") {
			arduino6.set(true);
			arduino7.set(false);
			arduino8.set(false);
			arduino9.set(true);
			armColorReq = "Front Switch";
		} else if(armColorReq == "Back Intake Intake") {
			arduino6.set(false);
			arduino7.set(true);
			arduino8.set(true);
			arduino9.set(false);
		} else if(armColorReq == "Back Intake Outtake") {
			arduino6.set(false);
			arduino7.set(false);
			arduino8.set(true);
			arduino9.set(true);
			armColorReq = "Back Intake";
		} else if(armColorReq == "Back Switch Outtake") {
			arduino6.set(true);
			arduino7.set(true);
			arduino8.set(true);
			arduino9.set(false);
			armColorReq = "Back Switch";
		} else if(armColorReq == "Emergency") {
			arduino6.set(false);
			arduino7.set(true);
			arduino8.set(true);
			arduino9.set(true);
		}
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new LEDCommand());
    }
}

