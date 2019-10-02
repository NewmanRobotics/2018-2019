package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by graham cooke on 9/24/2018.
 */

public class armBotHardware {

    public DcMotor right = null;
    public DcMotor left = null;
    public DcMotor arm = null;
    //public DcMotor screw = null;
    //public Servo basket = null;

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public armBotHardware(){
    }

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        right = hwMap.dcMotor.get("Right");
        left = hwMap.dcMotor.get("Left");

        left.setDirection(DcMotorSimple.Direction.REVERSE);

        right.setPower(0);
        left.setPower(0);

    }

    public void waitForTick(long periodMs) throws InterruptedException{

        long remaining = periodMs - (long) period.milliseconds();

        if (remaining > 0){
            Thread.sleep(remaining);

            period.reset();
        }

    }

}
