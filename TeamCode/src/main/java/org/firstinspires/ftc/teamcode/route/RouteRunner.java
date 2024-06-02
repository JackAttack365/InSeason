package org.firstinspires.ftc.teamcode.route;

import org.firstinspires.ftc.teamcode.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystem.Odometry;
import org.firstinspires.ftc.teamcode.subsystem.IMU;

import org.firstinspires.ftc.teamcode.util.trajectory.Pose2d;

import java.util.List;
import java.util.LinkedList;

public class RouteRunner {

    List<Pose2d> route = new List<Pose2d>();

    public RouteRunner(List<Pose2d> routeIn) {
        this.route = routeIn;
    }

    Thread poseUpdater = new Thread(() -> {
                waitForStart();
                Pose2d currentPose = Odometry.getPose();
                while(opModeIsActive()) {
                    currentPose = Odometry.getPose();
                }
            }).start();{

    for(Pose2d target : route) {
        turnToHeading(target.heading);

        while (currentPose != target) {
            if (Math.floor(currentPose.heading/10) != Math.floor(target.heading/10)) {
                driveTrain.turnToHeading(target.heading);
            }

            double deltaX = target.x - currentPose.x;
            double deltaY = target.y - currentPose.y; 
            
            double leftFrontPower = (deltaY + deltaX); // DO NOT CHANGE
            double rightFrontPower = (deltaY - deltaX); // DO NOT CHANGE
            double leftBackPower = (deltaY - deltaX); // DO NOT CHANGE
            double rightBackPower = (deltaY + deltaX); // DO NOT CHANGE
    
            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            double max;
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));
    
            if (max > 1.0) {
                leftFrontPower /= max;
                rightFrontPower /= max;
                leftBackPower /= max;
                rightBackPower /= max;
            }

            driveTrain.setMotorPowers();

        }
    }
}
}
