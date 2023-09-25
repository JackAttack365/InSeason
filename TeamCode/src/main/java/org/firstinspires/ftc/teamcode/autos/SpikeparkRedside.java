package org.firstinspires.ftc.teamcode.autos;




public class SpikeparkRedside extends Auto{
    public int idk = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
        // TODO: Add movement times. Uncomment
//        moveForward();
        moveForward(idk);
        strafeLeft(idk);
        // Place spike
        strafeRight(idk);
        moveRight(idk);
        //place on board
        //park



    }

}

