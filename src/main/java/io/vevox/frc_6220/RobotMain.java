package io.vevox.frc_6220;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by Carter on 1/19/16.
 * Will was here.
 */
public class RobotMain extends SampleRobot {
    private RobotDrive drive;
    private Joystick joystick;
    private Auto goit;
    //VictorSP victorSP1;
    //VictorSP victorSP2;
    public void robotInit() {
        //Motor init
        drive = new RobotDrive(0,2,3,4); //TODO Make this sane

        //UI
        SmartDashboard.putString("DB/String 0", "Test");
        SmartDashboard.putNumber("DB/String 5", 1.0);

        SmartDashboard.putString("DB/String 1", "Speed Forward: ");
        SmartDashboard.putString("DB/String 2", "Time Forward: ");
        SmartDashboard.putString("DB/String 3", "Speed Backward: ");
        SmartDashboard.putString("DB/String 4", "Time Backward: ");

        SmartDashboard.putNumber("DB/String 6", 1.0);
        SmartDashboard.putNumber("DB/String 7", 3.5);
        SmartDashboard.putNumber("DB/String 8", -1.0);
        SmartDashboard.putNumber("DB/String 9", .3);



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

        //Autonomous init
        goit = new Auto(drive);

        //Joystick init
        joystick = new Joystick(0);
    }

    //This function is called once each time the robot enters autonomous mode.
    public void autonomous() {
        // Put code here
        if (isAutonomous() && isEnabled()) {
            //goit.fastly(.4, .03);//1 is 5, wtf
            //goit.fastly(.5, .03);//1 is 5, wtf
            //goit.fastly(.55, .6);//1 is 5, wtf
            //goit.fastly(.5, .03);//1 is 5, wtf
            //goit.fastly(.4, .03);//1 is 5, wtf
            //goit.fastly(.01, .2);//1 is 5, wtf
            //goit.fastly(0.1, .03);//1 is 5, wtf

            //goit.fastly(.5, .05);//1 is 5, wtf
            //goit.fastly(1,.2);
            //goit.fastly(-.5, .1);

            //goit.fastly(1, .75);
            //goit.fastly(-1, .01);

            goit.fastly(SmartDashboard.getNumber("DB/String 6"), SmartDashboard.getNumber("DB/String 7"));
            goit.fastly(SmartDashboard.getNumber("DB/String 8"), SmartDashboard.getNumber("DB/String 9"));

            //goit.turn(45, Auto.direction.RIGHT);
            while (isAutonomous() && isEnabled()) {
                drive.tankDrive(0,0);
            }
        }
    }

    // This function is called once each time the robot enters teleop mode.
    public void operatorControl() {
        //int reverse = 1;
        while(isOperatorControl() && isEnabled()) {
            //http://team358.org/files/programming/ControlSystem2015-2019/images/XBoxControlMapping.jpg
            drive.tankDrive( -1 * (joystick.getRawAxis(1)), -1 * (joystick.getRawAxis(5))); //Sticks
            //drive.tankDrive(joystick.getRawAxis(2),joystick.getRawAxis(3)); //Triggers
            //victorSP1.set(0.1);
            //victorSP2.set(0.1);
            Timer.delay(0.005);
        }
    }
}
