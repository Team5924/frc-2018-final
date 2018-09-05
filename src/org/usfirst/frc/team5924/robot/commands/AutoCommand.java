package org.usfirst.frc.team5924.robot.commands;

import org.usfirst.frc.team5924.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommand extends CommandGroup {
	
    public AutoCommand(String robotPosReq, String gameDataReq) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	// To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	
    	if(gameDataReq.length() > 0){
    		
    		if(robotPosReq == "C"){ //CENTER POSITION AUTO CODE
    		
    			if(gameDataReq.charAt(0) == 'L'){ //CENTER POSITION LEFT SWITCH
    				//idea FIRST CUBE
    				//addSequential(new DriveTurnCommand("L", 40));
    				//addSequential(new AutoDriveCommand(40));
    				//addSequential(new DriveTurnCommand("R", 40));
    				//addSequential(new AutoDriveCommand(70.0));
    				//addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
					//addSequential(new CubeAutoCommand("O"));
    				
    				
    				//FIRST CUBE
    				addSequential(new StopRobot());
    				addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
					addSequential(new AutoDriveCommand(40.5));
					addSequential(new DriveTurnCommand("L", 90));
					addSequential(new AutoDriveCommand(75.5)); //+8
					addSequential(new DriveTurnCommand("R", 90)); 
    				addSequential(new AutoDriveCommand(63.5), 2.5); 
					addSequential(new CubeAutoCommand("O"));
					//addSequential(new AutoDriveCommand(-30));
					//addSequential(new ArmPositionAutoCommand(RobotConstants.frontIntakePos));
					//addSequential(new DriveTurnCommand("R", 40));
					//addParallel(new CubeAutoCommand("I"), 2);
					//addSequential(new AutoDriveCommand(-20));
					/**SECOND CUBE
					addSequential(new AutoDriveCommand(-10.0));//15 
					addSequential(new DriveTurnCommand("L", 45)); //change value
					addSequential(new AutoDriveCommand(-8.0)); //change value
					addSequential(new DriveTurnCommand("L", 90)); 
					addSequential(new ArmPositionAutoCommand(RobotConstants.backIntakePos));
					addParallel(new AutoDriveCommand(-8.0)); //change value
					addSequential(new CubeAutoCommand("I"));
							//undo
					addSequential(new AutoDriveCommand(8.0)); //change value
					addSequential(new DriveTurnCommand("R", 90));
					addSequential(new AutoDriveCommand(8.0)); //change value
					addSequential(new DriveTurnCommand("L", 45)); //change value
					addSequential(new AutoDriveCommand(15.0)); //change value 
					addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
					addSequential(new CubeAutoCommand("O");
					**/
					
					//****if**** third cube, repeat code for 2nd cube, change distances accordingly
					
    			} else{ //CENTER POSITION RIGHT SWITCH
    				//idea FIRST CUBE
    				//addSequential(new DriveTurnCommand("R", 40));
    				//addSequential(new AutoDriveCommand(40));
    				//addSequential(new DriveTurnCommand("L", 40));
    				//addSequential(new AutoDriveCommand(70.0));
    				//addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
					//addSequential(new CubeAutoCommand("O"));
    				
    				
    				//FIRST CUBE
    				addSequential(new StopRobot());
    				addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
    				addSequential(new AutoDriveCommand(40.5));
					addSequential(new DriveTurnCommand("R", 90));
					addSequential(new AutoDriveCommand(25)); //-5
					addSequential(new DriveTurnCommand("L", 90));
					addSequential(new AutoDriveCommand(63.5), 2.5);
					
					addSequential(new CubeAutoCommand("O"));
					//addSequential(new AutoDriveCommand(-30));
					
					//addSequential(new ArmPositionAutoCommand(RobotConstants.frontIntakePos));
					//addSequential(new DriveTurnCommand("L", 40));
					//addParallel(new CubeAutoCommand("I"), 2);
					//addSequential(new AutoDriveCommand(-20));
					//SECOND CUBE
					/**addSequential(new AutoDriveCommand(-15.0));
					addSequential(new DriveTurnCommand("L", 45)); //change value
					addSequential(new AutoDriveCommand(-8.0)); //change value
					addSequential(new DriveTurnCommand("L", 90)); 
					addSequential(new ArmPositionAutoCommand(RobotConstants.backSwitchPos));
					addParallel(new AutoDriveCommand(-8.0)); //change value
					addSequential(new CubeAutoCommand("I"));
							//undo
					addSequential(new AutoDriveCommand(8.0)); //change value
					addSequential(new DriveTurnCommand("R", 90));
					addSequential(new AutoDriveCommand(8.0)); //change value
					addSequential(new DriveTurnCommand("L", 45)); //change value
					addSequential(new AutoDriveCommand(15.0)); //change value
					addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
					addSequential(new CubeAutoCommand("O"));**/
					
					//****if**** third cube, repeat code for 2nd cube, change distances accordingly
					
    			}
    			
    		} else if(robotPosReq == "L"){ //LEFT POSITION AUTO CODE
    			
    			if(gameDataReq.charAt(0) == 'L'){ //LEFT POSITION LEFT SWITCH
    				//24
    				//option 1 --> drop off first cube in same position as center auto, and copy the rest of that code for following cubes
    				//option 2 --> what we had before, no change/little change for new arm
    				//FIRST CUBE --> option 2
    				addSequential(new StopRobot());
    				addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
	    			addSequential(new AutoDriveCommand(145.5)); 
					//addSequential(new DriveTurnCommand("R", 90)); 
					//addSequential(new AutoDriveCommand(20.5), 1); 
					//addSequential(new CubeAutoCommand("O"));
					//addSequential(new AutoDriveCommand(-25));
					//SECOND CUBE --> option 2
					//not tested
					
					//FIRST CUBE --> option 1
					/**addSequential(new AutoDriveCommand(40.5)); 
					addSequential(new DriveTurnCommand("R", 90)); 
					addSequential(new AutoDriveCommand(40.5)); //change value
					addSequential(new DriveTurnCommand("L", 90));**/
					//copy center auto Left
					
					
					
    			} else{ //LEFT POSITION RIGHT SWITCH
    				//FIRST CUBE
    				addSequential(new StopRobot());
    				addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
    				addSequential(new AutoDriveCommand(145.5)); //211
    				//addSequential(new DriveTurnCommand("R", 90));
    				//not tested
					/**addSequential(new AutoDriveCommand(174.0)); 
					addSequential(new DriveTurnCommand("R", 90));
					addSequential(new AutoDriveCommand(78.0)); 
					addParallel(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
					addSequential(new DriveTurnCommand("R", 90)); 
					addSequential(new AutoDriveCommand(10.5));
					addSequential(new CubeAutoCommand("O"));**/
					//SECOND CUBE
    			
    			}
    			
    		} else if(robotPosReq == "R"){ //RIGHT POSITION AUTO CODE
    			
    			if(gameDataReq.charAt(0) == 'L'){ //RIGHT POSITION LEFT SWITCH
    				
    				//FIRST CUBE
    				addSequential(new StopRobot());
    				addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
    				addSequential(new AutoDriveCommand(145.5)); //211
    				//addSequential(new DriveTurnCommand("L", 90));
    				//not tested
					/**addSequential(new AutoDriveCommand(174.0)); 
					addSequential(new DriveTurnCommand("L", 90));
					addSequential(new AutoDriveCommand(78.0)); 
					addParallel(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
					addSequential(new DriveTurnCommand("L", 90)); 
					addSequential(new AutoDriveCommand(10.5)); 
					addSequential(new CubeAutoCommand("O"));**/
					//SECOND CUBE
					
    			
    			} else if(gameDataReq.charAt(0) == 'R'){ //RIGHT POSITION RIGHT SWITCH
    				//FIRST CUBE --> option 2
    				addSequential(new StopRobot());
    				addSequential(new ArmPositionAutoCommand(RobotConstants.frontSwitchPos));
	    			addSequential(new AutoDriveCommand(145.5)); 
					//addSequential(new DriveTurnCommand("L", 90)); 
					//addSequential(new AutoDriveCommand(20.5), 1.5); 
					//addSequential(new CubeAutoCommand("O"));
					//addSequential(new AutoDriveCommand(-25));
					//SECOND CUBE --> option 2
					//not tested
					
					//FIRST CUBE --> option 1
					/**addSequential(new AutoDriveCommand(40.5)); 
					addSequential(new DriveTurnCommand("R", 90)); 
					addSequential(new AutoDriveCommand(40.5)); //change value
					addSequential(new DriveTurnCommand("L", 90));**/
					//copy center auto Left
					
    			}
    		} else if(robotPosReq == "A"){
    			
    			//addSequential(new AutoDriveCommand(150));
    		}
    	}
    } 	
}

    

