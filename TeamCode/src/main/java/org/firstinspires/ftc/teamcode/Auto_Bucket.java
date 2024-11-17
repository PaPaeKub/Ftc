package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Bucket")
public class Auto_Bucket extends Robot {

    private void keep(double pos) {
        SetServoPos(0, LLG, RLG);
        SetServoPos(0.34, LA, RA);
        SetServoPos(0.15, G);
        SetServoPos(pos, AG);
        SetServoPos(0.3, D);
        SetServoPos(0.15, LAG, RAG);
        SetServoPos(0.71, LFA, RFA);

        sleep(500);

        SetServoPos(0, G);
        sleep(300);
        SetServoPos(1, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        sleep(500);
        SetServoPos(0, LA, RA);
        SetServoPos(0, AG);
        sleep(300);
        SetServoPos(0, D);
        sleep(400);
        SetServoPos(0.2, G);
        sleep(100);
        SetServoPos(0, LAG, RAG);
    }

    private void drop() {
        SetServoPos(0.66, LLG, RLG);

        sleep(1000);

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
        while (!isStarted() && !isStopRequested()) {
            Posx = 0;
            Posy = 0;
            heading = 0;
        }
    }

    public void runOpMode() {
        Init();

        while (!(LTS.isPressed()) && !(RTS.isPressed())) {
            double spl = LTS.isPressed() ? 0 : -0.4;
            double spr = RTS.isPressed() ? 0 : -0.4;
            Lift_SetPower(spl, spr);
        }
        LiftPower(0);
        SetServoPos(0.5, LAG, RAG);

        LL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        WaitForStart();

        if (opModeIsActive()) {
            move(1.0, -0.77, 0.7, 218.0, new double[]{0.42, 0.01, 0.1},
                    new double[]{2.5, 0.001, 0.2, 0.0}, new double[]{0.25, 0.08, 0.015, 0.0}, new double[]{0.25, 0.01, 0.01, 0.0}, 0.001, High_Basket);

            drop();

            move(1.0, -0.7, 0.7, 188.0, new double[]{0.35, 0.007, 0.01},
                    new double[]{2.0, 0.002, 0.15, 0.0}, new double[]{0.25, 0.02, 0.025, 0.0}, new double[]{0.35, 0.009, 0.01, 0.0}, 0.001, 0);

            keep(0.25);

            move(1.0, -0.77, 0.7, 218.0, new double[]{0.42, 0.001, 0.06},
                    new double[]{1.0, 0.0008, 0.1, 0.0}, new double[]{0.1, 0.08, 0.015, 0.0}, new double[]{0.15, 0.01, 0.01, 0.0}, 0.001, High_Basket);

            drop();

            move(1.0, -0.95, 0.7, 180.0, new double[]{0.35, 0.007, 0.01},
                    new double[]{2.0, 0.002, 0.15, 0.0}, new double[]{0.25, 0.01, 0.025, 0.0}, new double[]{0.35, 0.0085, 0.01, 0.0}, 0.001, 0);

            keep(0);

            move(1.0, -0.77, 0.7, 218.0, new double[]{0.42, 0.001, 0.06},
                    new double[]{1.0, 0.0008, 0.1, 0.0}, new double[]{0.1, 0.08, 0.015, 0.0}, new double[]{0.15, 0.01, 0.01, 0.0}, 0.001, High_Basket);

            drop();

            move(1.0, -1.0, 0.75, 150.0, new double[]{0.3, 0.0009, 0.008},
                    new double[]{2.0, 0.002, 0.05, 0.0}, new double[]{0.15, 0.007, 0.0009, 0.0}, new double[]{0.3, 0.008, 0.01, 0.0}, 0.001, 0);

            keep(0.25);

            move(1.0, -0.77, 0.7, 218.0, new double[]{0.42, 0.001, 0.06},
                    new double[]{1.0, 0.0008, 0.1, 0.0}, new double[]{0.08, 0.009, 0.015, 0.0}, new double[]{0.15, 0.01, 0.01, 0.0}, 0.001, High_Basket);

            drop();

            move(1.0, 0.3, 2.2, 90.0, new double[]{0.45, 0.05, 0.08},
                    new double[]{4.0, 0.01, 0.001, 0.0}, new double[]{0.25, 0.01, 0.0095, 0.0}, new double[]{0.35, 0.01, 0.01, 0.0}, 0.001, 800);

            SetServoPos(0.66, LLG, RLG);

            sleep(10000);
//
//            move(0.5, -0.97, 0.8, 180.0, new double[]{0.42, 0.001, 0.06},
//                    new double[]{2.0, 0.0007, 0.15, 0.0}, new double[]{0.04, 0.004, 0.004, 0.0}, new double[]{0.08, 0.0001, 0.007, 0.0}, 0.01, 0);
//
//            keep();
//
//            move(0.5, -0.8, 0.7, 215.0, new double[]{0.42, 0.001, 0.06},
//                    new double[]{1.0, 0.0008, 0.1, 0.0}, new double[]{0.1, 0.08, 0.015, 0.0}, new double[]{0.15, 0.01, 0.008, 0.0}, 0.01, High_Basket);
//
//            drop();
//
//            move(1.0, 0.4, 2.2, 90.0, new double[]{0.42, 0.003, 0.06},
//                    new double[]{4.0, 0.004, 0.1, 0.0}, new double[]{0.11, 0.001, 0.015, 0.0}, new double[]{0.1, 0.0001, 0.008, 0.0}, 0.01, High_Chamber - 500);
//
//            SetServoPos(1, LLG, RLG);
//
//            sleep(100000);
        }
    }
}