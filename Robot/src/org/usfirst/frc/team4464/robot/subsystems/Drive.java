package org.usfirst.frc.team4464.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4464.robot.*;

/**
 *
 */
public class Drive extends Subsystem {
    
	private static Victor RightMotor0 = new Victor(RobotMap.DriveRightMotorPin[0]);
	private static Victor RightMotor1 = new Victor(RobotMap.DriveRightMotorPin[1]);
	private static Victor RightMotor2 = new Victor(RobotMap.DriveRightMotorPin[2]);
	private static Victor LeftMotor0 = new Victor(RobotMap.DriveLeftMotorPin[0]);
	private static Victor LeftMotor1 = new Victor(RobotMap.DriveLeftMotorPin[1]);
	private static Victor LeftMotor2 = new Victor(RobotMap.DriveLeftMotorPin[2]);
	
	
	private static DoubleSolenoid DriveSolenoid = new DoubleSolenoid(RobotMap.ShifterSolenoidPin[0], RobotMap.ShifterSolenoidPin[1]);
	
	public static void setRight(double x){
		System.out.println("SetRight: " + x);
		RightMotor0.set(x);
		RightMotor1.set(x);
		RightMotor2.set(x);
		RightMotor0.setSafetyEnabled(false);
		RightMotor0.updateTable();
		
	}
	
	public static void setLeft(double x){
		System.out.println("SetLeft: " + x);
		LeftMotor0.set(-x);
		LeftMotor1.set(-x);
		LeftMotor2.set(-x);
	}
	
	public static void shift(boolean setHighGear){
		System.out.println("Shift into " + (setHighGear ? "high" : "low") );
		if (setHighGear) {
			DriveSolenoid.set(DoubleSolenoid.Value.kForward);
		}
		else {
			DriveSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

