package org.firstinspires.ftc.teamcode.util.trajectory;

import org.firstinspires.ftc.teamcode.subsystem.Odometry;

import java.util.List;
import java.util.ArrayList;

public abstract class PoseTracker {
    public List<Pose2d> poses = new ArrayList<Pose2d>();

    public void init() {

    }

    public void update() {
        final int LEFT_ENCODER;
        final int RIGHT_ENCODER;
        final int MIDDLE_ENCODER;

        poses.add();
    }
}
