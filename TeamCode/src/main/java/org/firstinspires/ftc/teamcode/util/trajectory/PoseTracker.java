package org.firstinspires.ftc.teamcode.util.trajectory;

import org.firstinspires.ftc.teamcode.subsystem.Odometry;

import java.util.List;
import java.util.ArrayList;

public abstract class PoseTracker {
    public List<Pose2d> poses = new ArrayList<Pose2d>();

    public void init(Pose2d startPose) {
        poses.add(startPose);
    }

    public void update(Pose2d newPose) {
        poses.add(newPose);
    }
}