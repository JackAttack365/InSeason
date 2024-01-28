package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Special Park Red Left", group = "Parking Autos")
public class SpecialParkRedLeft extends Auto{
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();
        moveForward(forwardOneSquare * 3);
        spinCounterClockwise(turn90);
        moveBackward(backwardOneSquare * 5);
    }
}
