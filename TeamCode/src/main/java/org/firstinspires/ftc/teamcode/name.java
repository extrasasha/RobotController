package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="test",group="test2")
public class name extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive1 = null;
    private DcMotor leftDrive2 = null;
    private DcMotor rightDrive1 = null;
    private DcMotor rightDrive2 = null;
    private DcMotor handDrive1 = null;
    private DcMotor handDrive2 = null;
    private DcMotor handDrive11 = null;
    private DcMotor handDrive22 = null;
    @Override
    public void init() {
        leftDrive1 = hardwareMap.get(DcMotor.class,"leftDrive1");
        leftDrive2 = hardwareMap.get(DcMotor.class,"leftDrive2");
        rightDrive1 = hardwareMap.get(DcMotor.class,"rightDrive1");
        rightDrive2 = hardwareMap.get(DcMotor.class,"rightDrive2");
        handDrive1 = hardwareMap.get(DcMotor.class,"handDrive1");
        handDrive2 = hardwareMap.get(DcMotor.class,"handDrive2");
        handDrive11 = hardwareMap.get(DcMotor.class,"handDrive12");
        handDrive22 = hardwareMap.get(DcMotor.class,"handDrive21");


        leftDrive1.setDirection(DcMotor.Direction.REVERSE);
        leftDrive2.setDirection(DcMotor.Direction.REVERSE);
        rightDrive1.setDirection(DcMotor.Direction.FORWARD);
        rightDrive2.setDirection(DcMotor.Direction.FORWARD);
        handDrive1.setDirection(DcMotor.Direction.REVERSE);
        handDrive2.setDirection(DcMotor.Direction.FORWARD);
        handDrive11.setDirection(DcMotor.Direction.REVERSE);
        handDrive22.setDirection(DcMotor.Direction.REVERSE);

        handDrive1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        handDrive2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        handDrive1.setTargetPosition(0);
        handDrive2.setTargetPosition(0);

        handDrive1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        handDrive2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    @Override
    public void init_loop() {
    }


    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {

        double leftPower;
        double rightPower;


        leftPower = -gamepad1.left_stick_y;
        rightPower = -gamepad1.right_stick_y;

        if (gamepad1.y) {
            handDrive1.setTargetPosition(700);
            handDrive2.setTargetPosition(700);

            handDrive1.setPower(0.7);
            handDrive2.setPower(0.7);
        }
        if (gamepad1.a) {
            handDrive1.setTargetPosition(100);
            handDrive2.setTargetPosition(100);

            handDrive1.setPower(0.3);
            handDrive2.setPower(0.3);

        }

        handDrive11.setPower(gamepad1.right_trigger);
        handDrive22.setPower(gamepad1.right_trigger);

        handDrive11.setPower(-gamepad1.left_trigger);
        handDrive22.setPower(-gamepad1.left_trigger);


        leftDrive1.setPower(leftPower);
        rightDrive1.setPower(rightPower);
        leftDrive2.setPower(leftPower);
        rightDrive2.setPower(rightPower);


        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);


    }}
