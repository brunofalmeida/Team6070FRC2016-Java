
package org.usfirst.frc.team6070.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;

public class Robot extends IterativeRobot {
	RobotDrive drive = new RobotDrive(0,1,2,3);
	Victor v1 = new Victor (4);
	Victor v2 = new Victor (5);
	Joystick joy = new Joystick (0);
	Joystick netjoy = new Joystick (1);

    public void robotInit() {
       
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //v2.set(joy.getX()+joy.getY());
    	//v1.set(joy.getX()-joy.getY());
    	if (joy.getX() > 0.1 && joy.getX() < -0.1 && joy.getY() > 0.1 && joy.getY() < -0.1){ // deadzone: prevents acccidental movement.
    		drive.mecanumDrive_Cartesian(joy.getX(), joy.getY(), joy.getZ(), 0);
    	}	
    	if (netjoy.getY() > 0.1) // sets a deadzone for the controller. We can adjust this as needed. 
    	{
    		v1.set(0.5);
    		v2.set(-0.5);
    	}
    	else if (netjoy.getY() < -0.1)
    	{
    		v1.set(-0.5);
    		v2.set(0.5);
    	}
    	Timer.delay(0.01);
    }
    
    /**
     * This function is called periodically during test mode
     */

}
