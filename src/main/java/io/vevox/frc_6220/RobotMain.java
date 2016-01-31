package io.vevox.frc_6220;

import edu.wpi.first.wpilibj.*;

/**
 * Created by matt on 1/19/16.
 * Will was here.
 */
public class RobotMain extends SampleRobot {
    RobotDrive drive;
    Joystick joystick;
    VictorSP victorSP1;
    VictorSP victorSP2;
    public void robotInit() {
        //Motor
        drive = new RobotDrive(1,2,3,4);
        drive = new RobotDrive(1,2);
        //victorSP1 = new VictorSP(1);
        //victorSP2 = new VictorSP(2);
        //Debug
        boolean debug = false;
        double voltage = DriverStation.getInstance().getBatteryVoltage();
        BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
        if (debug) {
            System.out.println("Xbox controller? " + joystick.getIsXbox());
            System.out.println("Number of axes: " + joystick.getAxisCount());
        }
        while (debug) {
            System.out.println("Voltage: " + voltage);
            System.out.println("X acceleration: " + accelerometer.getX());
            System.out.println("Y acceleration: " + accelerometer.getY());
            System.out.println("Z acceleration: " + accelerometer.getZ());
        }
        //Joystick
        joystick = new Joystick(0);
        //victorSP1.set(0.1);
        //victorSP2.set(0.1);
        Timer.delay(0.01);
    }

    //This function is called once each time the robot enters autonomous mode.
    public void autonomous() {
        // Put code here
        while (isAutonomous() && isEnabled()) {
            drive.tankDrive(0.1,0.1);
        }
        Timer.delay(0.05);
    }

    // This function is called once each time the robot enters teleop mode.
    public void operatorControl() {
        while(isOperatorControl() && isEnabled()) {
            //http://team358.org/files/programming/ControlSystem2015-2019/images/XBoxControlMapping.jpg
            drive.tankDrive(joystick.getRawAxis(2), -1 * (joystick.getRawAxis(2)));
            //victorSP1.set(0.1);
            //victorSP2.set(0.1);
            Timer.delay(0.01);
        }
    }
}
