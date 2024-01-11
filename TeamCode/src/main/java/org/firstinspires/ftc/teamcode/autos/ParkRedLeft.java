package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "ParkRedLeft", group = "Parking Autos")
public class ParkRedLeft extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        moveForward((long)(forwardOneSquare*1.3));
        spinClockwise(turn90);
        moveForward(forwardOneSquare*3);
        strafeRight((long)(strafeLeftOneSquare*1.4));
        moveForward(forwardOneSquare*2);
    }
}
