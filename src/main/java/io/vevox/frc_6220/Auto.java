package io.vevox.frc_6220;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

/**
 * Created by Bob on 3/31/2016.
 */
public class Auto {
    enum direction {
        LEFT, RIGHT
    }

    RobotDrive drive;

    public Auto(RobotDrive drive) {
        this.drive = drive;
    }

    public void fastly(double speed, double time) {
        time *= 100;
        for (int i = 0; i <= time; i++) {
            drive.tankDrive(speed, speed - .1);
            Timer.delay(.01);
        }
    }

    public void turn(double degrees, direction direction) {
        //degrees *= 10;
        int d = 1;
        if (direction == Auto.direction.LEFT) d = -1;
        for (int i = 0; i <= degrees; i++) {
            drive.tankDrive((d), (-1 * d));
        }
    }

}
