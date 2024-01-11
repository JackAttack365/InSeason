package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "ParkBlueRight", group = "Parking Autos")
public class ParkBlueRight extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward((long)(forwardOneSquare*1.3));
        spinCounterClockwise(turn90);
        moveForward(forwardOneSquare*3);
        strafeLeft((long)(strafeLeftOneSquare*1.4));
        moveForward(forwardOneSquare*2);
    }
}
