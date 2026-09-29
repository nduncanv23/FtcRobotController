package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "PepRally1.java")
public class PepRally1 extends LinearOpMode {

    private DcMotor motor01launcher;
    private DcMotor motor04launcher;
    private DcMotor motor02leftwheel;
    private DcMotor motor03rightwheel;
    private Servo servo0;

    @Override
    public void runOpMode() {
        motor01launcher = hardwareMap.get(DcMotor.class, "motor01 -launcher");
        motor04launcher = hardwareMap.get(DcMotor.class, "motor04 -launcher");
        motor02leftwheel = hardwareMap.get(DcMotor.class, "motor02 -left wheel");
        motor03rightwheel = hardwareMap.get(DcMotor.class, "motor03 -right wheel");
        servo0 = hardwareMap.get(Servo.class, "servo 0");
        waitForStart();
        while (opModeIsActive()) {
            //
            motor01launcher.setDirection(DcMotor.Direction.REVERSE);
            motor04launcher.setDirection(DcMotor.Direction.REVERSE);
            motor03rightwheel.setDirection(DcMotor.Direction.FORWARD);
            motor02leftwheel.setDirection(DcMotor.Direction.FORWARD);
            //
            motor02leftwheel.setPower(gamepad1.right_stick_x);
            motor03rightwheel.setPower(gamepad1.left_stick_x);
            //
            motor04launcher.setPower(gamepad1.left_stick_y);
            motor01launcher.setPower(gamepad1.right_stick_y);

            if (gamepad1.dpad_up) {
                servo0.setPosition(0);
            }
            if (gamepad1.dpad_down) {
                servo0.setPosition(90);
            }
            if (gamepad1.dpad_left) {
                servo0.setPosition(270);
            }

        }

    }
}