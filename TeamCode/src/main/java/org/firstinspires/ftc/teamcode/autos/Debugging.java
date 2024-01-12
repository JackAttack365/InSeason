package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="debugging", group = "Debugging")
public class Debugging extends Auto{

    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();
        waitForStart();
    }
}
