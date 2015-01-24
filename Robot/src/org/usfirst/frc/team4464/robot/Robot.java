
package org.usfirst.frc.team4464.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4464.robot.commands.*;
import org.usfirst.frc.team4464.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

//	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static Compressor compressor;
	
	RobotDrive myRobot;
	Joystick stick;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		compressor = new Compressor();

    	
		System.out.println("Init the robot!");
        // instantiate the command used for the autonomous period
		
        compressor.start();
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
//		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	System.out.println("Autonomous Init!");
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	System.out.println("Autonomous Periodic!");

        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	System.out.println("Telop Init!");
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        System.out.println("Telop Periodic");
//        System.out.println(oi.Gamepad.getRawAxis())       
        Scheduler.getInstance().run();
        Drive.setLeft(oi.Gamepad.getRawAxis(1)*.5);
        Drive.setRight(oi.Gamepad.getRawAxis(4)*.5);
        
        if (oi.ShiftHighButton.get()){
        	Drive.shift(true);
        }
        if (oi.ShiftLowButton.get()){
        	Drive.shift(false);
        }
    } 
       
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
//		Relay relay0= new Relay(0);
//		relay0.set(Value.kForward);
//		relay0.updateTable();
//		
//		Relay relay1 = new Relay(1);
//		relay1.set(Value.kOn);
//		relay1.updateTable();
        LiveWindow.run();
    }
}
