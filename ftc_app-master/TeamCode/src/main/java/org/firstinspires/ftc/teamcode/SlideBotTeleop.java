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

        float driveSpeed = 0.6f;
        float sweepSpeed = 1f;

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
                if(driveSpeed == 1f){
                    driveSpeed = 0.6f;
                } else {
                    driveSpeed = 1f;
                }
                speedDown = true;
            } else if (!gamepad1.right_bumper){
                speedDown = false;
            }

            lPower = -driveSpeed*gamepad1.left_stick_y;
            rPower = -driveSpeed*gamepad1.right_stick_y;

            robot.left.setPower(lPower);
            robot.right.setPower(rPower);

            slide = -gamepad2.left_stick_y;

            robot.slide.setPower(slide);

            telemetry.update();

            robot.waitForTick(5);
            idle();
        }
    }
}
