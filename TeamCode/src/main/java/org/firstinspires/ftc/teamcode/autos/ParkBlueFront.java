package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "ParkBlueLeft")
public class ParkBlueFront extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward(forwardOneSquare/4);
        strafeLeft(strafeLeftOneSquare*2);

    }
}
