/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.claw.AutomaticallyOpenClawAtEndOfMatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Pneumatic Claw Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class Claw extends Subsystem {

	private final DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.PCM_CANID, RobotMap.LEFT_SOLENOID_PORT, RobotMap.RIGHT_SOLENOID_PORT);
    private boolean isOpen;
	
    public void initDefaultCommand() {
        setDefaultCommand(new AutomaticallyOpenClawAtEndOfMatch());
    }
    
    /**
     * Opens the claw by retracting pistons
     */
    public void open() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    	isOpen = true;
    }
    
    /**
     * Closes the claw by extending pistons
     */
    public void close() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    	isOpen = false;
    }
    
    /**
     * Prints if claw is open or closed to smart dashboard (approximate, as claw cannot open as fast as the button is pressed)
     */
    public void log() {
    	SmartDashboard.putBoolean("Is Claw Set To Close", isOpen);
    }
}

