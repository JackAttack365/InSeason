package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

public class Arm extends SubSystem {

    private DcMotor lowerArmMotorRight;
    //private DcMotor lowerArmMotorLeft;
    private DcMotor upperArmMotor;
    public Arm (Config config) {
        super(config);
    }

    public Arm(Config config, boolean isOneController) {
        super(config, isOneController);
    }

    @Override
    public void init() {
        lowerArmMotorRight = config.hardwareMap.get(DcMotor.class, Config.RIGHT_LOW_ARM_MOTOR);
        //lowerArmMotorLeft = config.hardwareMap.get(DcMotor.class, Config.LEFT_LOW_ARM_MOTOR);
        upperArmMotor = config.hardwareMap.get(DcMotor.class, Config.UP_ARM_MOTOR);


    }

    @Override
    public void update() {


        // TODO: TUNE SPEED
        if(isOneController) {
            if (config.gamePad2.dpad_down){
                lowerArmMotorRight.setPower(-1);

            }
            if (config.gamePad2.dpad_up){
                lowerArmMotorRight.setPower(1);
            }


            if (config.gamePad2.x) {
                upperArmMotor.setPower(0.339);
            } else if (config.gamePad2.y) {
                upperArmMotor.setPower(-0.339);
            } else {
                upperArmMotor.setPower(0);
            }
        }
        else {
            double maxSpeed = 1;
            double speed = config.gamePad2.left_stick_y / 1.5;

            if (speed > maxSpeed) {
                speed = maxSpeed;
            }

            lowerArmMotorRight.setPower(speed);
            //lowerArmMotorLeft.setPower(speed);

            if (config.gamePad2.x) {
                upperArmMotor.setPower(0.339);
            } else if (config.gamePad2.y) {
                upperArmMotor.setPower(-0.339);
            } else {
                upperArmMotor.setPower(0);
            }
        }



    }
}
