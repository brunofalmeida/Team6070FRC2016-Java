
package org.usfirst.frc.team6070.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;

public class Robot extends IterativeRobot {
	Victor FL = new Victor (1);
	Victor FR = new Victor (0);
	Victor BL = new Victor (3);
	Victor BR = new Victor (2);
	RobotDrive drive = new RobotDrive(FR, FL, BR, BL);
	Victor v1 = new Victor (4);
	Victor v2 = new Victor (5);
	Joystick joy = new Joystick (0);
	Joystick netjoy = new Joystick (1);

    public void robotInit() {
       
    }
    
	
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
        v2.set(joy.getX()+joy.getY());
    	v1.set(joy.getX()-joy.getY());
    	if (joy.getX() > 0.1 && joy.getX() < -0.1 && joy.getY() > 0.1 && joy.getY() < -0.1){
    		drive.mecanumDrive_Cartesian(joy.getX(), joy.getY(), joy.getZ(), 0);
    	}	
    	if (netjoy.getY() > 0.1)
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
