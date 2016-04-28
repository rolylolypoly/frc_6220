package io.vevox.frc_6220;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Created by Bob on 3/31/2016.
 */
public class Auto {
    private enum direction {
        LEFT, RIGHT
    }

    private RobotDrive drive;

    Auto(RobotDrive drive) {
        this.drive = drive;
    }

    void fastly(double speed, double time) {
        time *= 1000;
        //for (int i = 0; i <= time; i++) {
        //    drive.tankDrive(speed, speed - .1);
        //    Timer.delay(.01);
        //}
        double end = time + System.currentTimeMillis();
        while (end >= System.currentTimeMillis()) {
            drive.tankDrive(speed, speed);
        }
    }

    public void turn(double degrees, direction direction) {
        //degrees *= 10;
        int d = 1;
        if (direction == Auto.direction.LEFT) d = -1;
        //for (int i = 0; i <= degrees; i++) {
        //    drive.tankDrive((d), (-1 * d));
        //}
        double end = (degrees * 1000) + System.currentTimeMillis();
        while (end >= System.currentTimeMillis()) {
            drive.tankDrive((d), (-1 * d));
        }
    }

}
