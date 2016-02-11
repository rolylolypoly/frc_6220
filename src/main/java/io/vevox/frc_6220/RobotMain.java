package io.vevox.frc_6220;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by matt on 1/19/16.
 * Will was here.
 */
public class RobotMain extends SampleRobot {
    RobotDrive drive;
    Joystick joystick;
    //VictorSP victorSP1;
    //VictorSP victorSP2;
    public void robotInit() {
        //Motor
        drive = new RobotDrive(0,2,3,4);
        //drive = new RobotDrive(1,2);
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
        CameraServer.getInstance().startAutomaticCapture();
    }

    //This function is called once each time the robot enters autonomous mode.
    public void autonomous() {
        // Put code here
        while (isAutonomous() && isEnabled()) {
            for (int i = 0; i < 200; i++) {
                drive.tankDrive(0.5,0.5);
            }
        }
        Timer.delay(0.01);
    }

    // This function is called once each time the robot enters teleop mode.
    public void operatorControl() {
        int reverse = 1;
        while(isOperatorControl() && isEnabled()) {
            //http://team358.org/files/programming/ControlSystem2015-2019/images/XBoxControlMapping.jpg
            //drive.tankDrive( -1 * (joystick.getRawAxis(1)), -1 * (joystick.getRawAxis(5)));
            drive.tankDrive(joystick.getRawAxis(2),joystick.getRawAxis(3));
            //victorSP1.set(0.1);
            //victorSP2.set(0.1);
            Timer.delay(0.01);
        }
    }
}
