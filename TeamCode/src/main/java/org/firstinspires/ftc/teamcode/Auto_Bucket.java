package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Bucket", group = "In")
public class Auto_Bucket extends Robot {

    private void keep(double pos) {
        SetServoPos(0, LLG, RLG);
        SetServoPos(0.34, LA, RA);
        SetServoPos(0, G);
        SetServoPos(pos, AG);
        sleep(300);
        SetServoPos(0.3, D);
        SetServoPos(0.11, LAG, RAG);
        SetServoPos(0.71, LFA, RFA);

        sleep(600);

        SetServoPos(0.24, G);
        sleep(100);
        SetServoPos(0, AG);
        SetServoPos(1, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        sleep(500);
        SetServoPos(0, LA, RA);
        sleep(300);
        SetServoPos(0.05, D);
        sleep(200);
        SetServoPos(0, G);
        sleep(100);
        SetServoPos(0, LAG, RAG);
    }

    private void drop() {
        SetServoPos(0.66, LLG, RLG); // 0.59

        sleep(600);

        SetServoPos(0.5, D);

        sleep(400);

        SetServoPos(0, LLG, RLG);
        SetServoPos(0, D);
    }

    private void Init() {
        // Initialize Robot
        Initialize(DcMotor.RunMode.RUN_WITHOUT_ENCODER, new double[]{0, 0, 0},
                new double[]{0.3, 0, 0.1, 0});
        imu.resetYaw();
    }

    private void WaitForStart() {
        while (!(LTS.isPressed())) {
            double power = LTS.isPressed() ? 0 : -0.3;
            LiftPower(power);
        }
        LiftPower(0);

        LL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ML.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ML.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        while (!isStarted() && !isStopRequested()) {
            Posx = 0;
            Posy = 0;
            heading = 0;
        }
    }

    public void runOpMode() {
        Init();
        WaitForStart();

        if (opModeIsActive()) {
            move(1.0, -0.78, 0.49, 219.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{0.8, 0.01, 0.09, 0.0}, new double[]{0.09, 0.01, 0.01, 0.0}, new double[]{0.09, 0.01, 0.003, 0.0}, 0.0001, High_Basket, 2.5);

            drop();

            move(1.0, -0.5, 0.68, 180.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{1.5, 0.002, 0.15, 0.0}, new double[]{0.09, 0.01, 0.004, 0.0}, new double[]{0.03, 0.0001, 0.003, 0.0}, 0.0001, 20, 2.5);

            keep(0);

            move(1.0, -0.79, 0.5, 219.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{1.2, 0.01, 0.09, 0.0}, new double[]{0.08, 0.01, 0.01, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, High_Basket, 2);

            drop();

            move(1.0, -0.97, 0.66, 180.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{1.5, 0.002, 0.15, 0.0}, new double[]{0.08, 0.01, 0.025, 0.0}, new double[]{0.03, 0.001, 0.003, 0.0}, 0.0001, 20, 2.5);

            keep(0);

            move(1.0, -0.79, 0.49, 219.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{1.2, 0.01, 0.09, 0.0}, new double[]{0.08, 0.01, 0.01, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, High_Basket, 2);

            drop();

            move(1.0, -0.93, 0.77, 150.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{1.0, 0.0007, 0.05, 0.0}, new double[]{0.04, 0.007, 0.001, 0.0}, new double[]{0.05, 0.0009, 0.003, 0.0}, 0.0001, 20, 2.5);

            keep(0.15);

            move(1.0, -0.79, 0.49, 219.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{1.2, 0.01, 0.09, 0.0}, new double[]{0.08, 0.01, 0.01, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, High_Basket, 2);

            drop();

            move(1.0, 0.47, 2.4, 90.0, new double[]{0.05, 0.2, 0.2},
                    new double[]{2.0, 0.01, 0.2, 0.0}, new double[]{0.05, 0.04, 0.03, 0.0}, new double[]{0.18, 0.01, 0.03, 0.0}, 0.0001, 800, 5);

            SetServoPos(0.85, LLG, RLG); // 0.55

            sleep(500);
        }
    }
}