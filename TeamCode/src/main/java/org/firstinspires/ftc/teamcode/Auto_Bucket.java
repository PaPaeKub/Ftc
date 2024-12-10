package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Bucket")
public class Auto_Bucket extends Robot {

    private void keep(double pos) {
        SetServoPos(0, LLG, RLG);
        SetServoPos(0.34, LA, RA);
        SetServoPos(0, G);
        SetServoPos(pos, AG);
        SetServoPos(0.3, D);
        SetServoPos(0.11, LAG, RAG);
        SetServoPos(0.7, LFA, RFA);

        sleep(500);

        SetServoPos(0.27, G);
        sleep(100);
        SetServoPos(0, AG);
        SetServoPos(1, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        sleep(500);
        SetServoPos(0, LA, RA);
        sleep(200);
        SetServoPos(0, D);
        sleep(200);
        SetServoPos(0, G);
        sleep(100);
        SetServoPos(0, LAG, RAG);
    }

    private void drop() {
        SetServoPos(1, LLG, RLG); // 0.59

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
            double power = LTS.isPressed() ? 0 : -0.4;
            Lift_SetPower(power, power);
        }
        LiftPower(0);
        SetServoPos(0.5, LAG, RAG);

        LL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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
            move(1.0, -0.78, 0.56, 219.0, new double[]{0.05, 0.19, 0.19},
                    new double[]{1.5, 0.01, 0.09, 0.0}, new double[]{0.08, 0.01, 0.01, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, High_Basket);

            drop();

            move(1.0, -0.68, 0.67, 189.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{1.5, 0.002, 0.15, 0.0}, new double[]{0.11, 0.01, 0.004, 0.0}, new double[]{0.08, 0.001, 0.003, 0.0}, 0.0001, 0);

            keep(0);

            move(1.0, -0.79, 0.56, 219.0, new double[]{0.05, 0.19, 0.19},
                    new double[]{1.5, 0.01, 0.09, 0.0}, new double[]{0.08, 0.01, 0.01, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, High_Basket);

            drop();

            move(1.0, -1.0, 0.67, 180.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{1.5, 0.002, 0.15, 0.0}, new double[]{0.1, 0.01, 0.025, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, 0);

            keep(0);

            move(1.0, -0.82, 0.53, 219.0, new double[]{0.05, 0.19, 0.19},
                    new double[]{1.5, 0.01, 0.09, 0.0}, new double[]{0.08, 0.01, 0.01, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, High_Basket);

            drop();

            move(1.0, -0.94, 0.75, 150.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{1.0, 0.0007, 0.05, 0.0}, new double[]{0.1, 0.007, 0.001, 0.0}, new double[]{0.08, 0.0009, 0.003, 0.0}, 0.0001, 0);

            keep(0.15);

            move(1.0, -0.79, 0.56, 219.0, new double[]{0.05, 0.19, 0.19},
                    new double[]{1.5, 0.01, 0.09, 0.0}, new double[]{0.08, 0.01, 0.01, 0.0}, new double[]{0.08, 0.01, 0.003, 0.0}, 0.0001, High_Basket);

            drop();

            move(1.0, 0.37, 2.5, 90.0, new double[]{0.25, 0.15, 0.15},
                    new double[]{1.7, 0.01, 0.2, 0.0}, new double[]{0.08, 0.04, 0.03, 0.0}, new double[]{0.18, 0.01, 0.03, 0.0}, 0.0001, 800);

            SetServoPos(0.85, LLG, RLG); // 0.55

            sleep(500);
        }
    }
}