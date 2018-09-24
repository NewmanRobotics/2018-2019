package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="teleopBasic", group="Teleop")
@Disabled
public class teleopBasic extends LinearOpMode {

    basicHardware robot = new basicHardware();

    @Override
    public void runOpMode() throws InterruptedException{

        float left, right = 0;

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {


            left = gamepad1.left_stick_y;
            right = gamepad1.right_stick_y;

            robot.left.setPower(left);
            robot.right.setPower(right);

            telemetry.addData("Left Power", left);
            telemetry.addData("Right Power", right);

            telemetry.update();

            robot.waitForTick(10);
            idle();
        }
    }
}