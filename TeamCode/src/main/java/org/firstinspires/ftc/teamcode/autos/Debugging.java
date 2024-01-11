package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="debugging", group = "Debugging")
public class Debugging extends Auto{

    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();
//        moveBackward(backwardOneSquare);
//        sleep(3000);
//        moveForward(forwardOneSquare);
//        sleep(3000);
//        strafeLeft(strafeLeftOneSquare);
//        sleep(3000);
//        strafeRight(strafeRightOneSquare);
//        sleep(3000);
        spinCounterClockwise(turn90);
        sleep(3000);
        spinCounterClockwise(turn180);
    }
}
