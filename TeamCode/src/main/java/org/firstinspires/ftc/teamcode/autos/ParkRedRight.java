package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "ParkRedRight", group = "Parking Autos")
public class ParkRedRight extends Auto {

    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare/4);
        strafeRight(strafeRightOneSquare*2);
    }
}

