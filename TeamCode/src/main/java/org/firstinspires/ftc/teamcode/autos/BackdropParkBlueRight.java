package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.subsystem.Claw;

import java.util.concurrent.atomic.AtomicBoolean;

@Autonomous(name = "ScoreParkBlueRight", group = "Scoring Autos")
public class BackdropParkBlueRight extends Auto{

    private AtomicBoolean holdingTorque = new AtomicBoolean(true);
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();

        new Thread(() -> {
            while(opModeIsActive()) {
                if (holdingTorque.get()) {
                    clawServo1.setPosition(Claw.CLAW_1_CLOSED);
                    clawServo2.setPosition(Claw.CLAW_2_CLOSED);
                } else {
                    clawServo1.setPosition(Claw.CLAW_1_OPEN);
                    clawServo2.setPosition(Claw.CLAW_2_OPEN);
                }
            }
        }).start();

        moveForward((long)(forwardOneSquare*1.2));
        spinCounterClockwise(turn90);
        moveForward(forwardOneSquare*3);
        strafeLeft(strafeLeftOneSquare/4);
        spinCounterClockwise(turn180);
        moveBackward(backwardOneSquare);
        spinCounterClockwise(turn90/4);
        moveBackward(backwardOneSquare/4);
        score();
        sleep(1000);
        holdingTorque.set(false);
        sleep(3000);
        strafeRight(strafeRightOneSquare+(strafeRightOneSquare/2));
        moveBackward(backwardOneSquare/2);
    }
}