package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Graham Cooke on 9/28/2016.
 */
@TeleOp(name = "SlideBotTeleOp", group = "Tank")

public class SlideBotTeleop extends LinearOpMode {

    SlideBotHardware robot = new SlideBotHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        float lPower = 0;
        float rPower = 0;

        float c = 0.6f;
        float s = 1f;

        float drive;
        float turn;

        float slide;
        float sweeper;

        boolean speedDown = false;
        boolean sweeperDown = false;

        boolean armUp = false;

        robot.init(hardwareMap);

        robot.slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        // Main Loop
        while(opModeIsActive()){

            // Toggles slow drive mode
            if(gamepad1.right_bumper && !speedDown){
                if(c == 1f){
                    c = 0.6f;
                } else {
                    c = 1f;
                }
                speedDown = true;
            } else if (!gamepad1.right_bumper){
                speedDown = false;
            }
            // Toggles Sweeper Direction
            if(gamepad1.left_bumper && !sweeperDown){
                if(s == 1f){
                    s = -1f;
                } else {
                    s = 1f;
                }
                sweeperDown = true;
            } else if (!gamepad1.left_bumper){
                sweeperDown = false;
            }

            sweeper = s*gamepad1.left_trigger;
            // Toggles basket arm lift
            if(gamepad2.y){
                armUp = true;
            }

            if(gamepad2.x){
                armUp = false;
            }

            lPower = -c*gamepad1.left_stick_y;
            rPower = -c*gamepad1.right_stick_y;

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);

            slide = -gamepad2.left_stick_y;

            robot.slide.setPower(slide);
            robot.sweeper.setPower(sweeper);

            if(armUp){
                robot.arm.setPosition(0);
            } else {
                robot.arm.setPosition(1);
            }

            telemetry.update();

            robot.waitForTick(10);
            idle();
        }
    }
}
