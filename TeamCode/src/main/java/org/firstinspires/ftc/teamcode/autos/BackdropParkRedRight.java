package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.subsystem.Claw;

import java.util.concurrent.atomic.AtomicBoolean;

@Autonomous(name = "ScoreParkRedRight", group = "Scoring Autos")
public class BackdropParkRedRight extends Auto{

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

        moveForward(forwardOneSquare/4);
        strafeRight(strafeRightOneSquare);
        moveForward((long)(forwardOneSquare*1.5));
        spinCounterClockwise(turn90);
        moveBackward((long) (backwardOneSquare*0.9));
        score();
        sleep(1000);
        holdingTorque.set(false);
        sleep(2000);
        moveForward(forwardOneSquare/8);
        strafeLeft((long)(strafeLeftOneSquare*1.5));
        moveBackward(backwardOneSquare/5);
    }
}
