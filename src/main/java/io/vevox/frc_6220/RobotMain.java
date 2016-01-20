package io.vevox.frc_6220;

import edu.wpi.first.wpilibj.*;

/**
 * Created by matt on 1/19/16.
 * Will was here.
 */
public class RobotMain extends SampleRobot {
    RobotDrive drive;
    Joystick joystick;
    public void robotInit() {
        //Debug
        boolean debug = false;
        double voltage = DriverStation.getInstance().getBatteryVoltage();
        BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
        while (debug) {
            System.out.println("Voltage: " + voltage);
            System.out.println("X acceleration: " + accelerometer.getX());
            System.out.println("Y acceleration: " + accelerometer.getY());
            System.out.println("Z acceleration: " + accelerometer.getZ());
        }
        //Joystick
        drive = new RobotDrive(1,2,3,4);
        joystick = new Joystick(1);

    }

    //This function is called once each time the robot enters autonomous mode.
    public void autonomous() {
        // Put code here
        Timer.delay(0.05);
    }

    // This function is called once each time the robot enters teleop mode.
    public void operatorControl() {
        while(isOperatorControl() && isEnabled()) {
            //Put code here
            drive.arcadeDrive(joystick);
            Timer.delay(0.01);
        }
    }
}
