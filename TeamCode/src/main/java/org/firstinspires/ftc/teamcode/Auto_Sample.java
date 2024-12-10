package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Sample")
public class Auto_Sample extends Robot {
    int i = 0;
    double plate = -0.15;

    private void Init() {
        // Initialize Robot
        Initialize(DcMotor.RunMode.RUN_WITHOUT_ENCODER, new double[]{0, 0, 0},
                new double[]{0.3, 0, 0.1, 0});
        imu.resetYaw();

    }

    private void WaitForStart() {
        while (!(LTS.isPressed())) {
            double power = LTS.isPressed() ? 0 : -0.25;
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

    private void keep(double pos) {
        SetServoPos(0, LLG, RLG);
        SetServoPos(0.5, LA, RA);
        SetServoPos(pos, AG);
        SetServoPos(0, G);
        SetServoPos(0.11, LAG, RAG);
        SetServoPos(0.7, LFA, RFA);

        sleep(500);

        SetServoPos(0.27, G);
        sleep(150);
        SetServoPos(0.6, LFA, RFA);
//        SetServoPos(0, LFA, RFA);
//        sleep(100);
//        SetServoPos(0, AG);
//        SetServoPos(0, LA, RA);
//        SetServoPos(0, LAG, RAG);
    }

    private void place() {
        SetServoPos(0.5, LA, RA);
        SetServoPos(0.15, LAG, RAG);
        SetServoPos(0.69, LFA, RFA);
        sleep(100);
        SetServoPos(0, G);
        sleep(100);
        SetServoPos(0, LA, RA);
        SetServoPos(0, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        SetServoPos(0, AG);
    }

    private void specimen() {
        SetServoPos(0, LLG, RLG);
        SetServoPos(0.5, LA, RA);
        sleep(200);
        SetServoPos(0, G);
        SetServoPos(0.25, AG);
        SetServoPos(0.3, D);
        SetServoPos(0.11, LAG, RAG);
        SetServoPos(0.5, LFA, RFA);

        SetServoPos(0.71, LFA, RFA);

        sleep(300);

        SetServoPos(0.22, G);
        sleep(100);
        SetServoPos(0, AG);
        SetServoPos(1, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        sleep(300);
        SetServoPos(0, LA, RA);
        sleep(200);
        SetServoPos(0, D);
        sleep(200);
        SetServoPos(0, G);
        sleep(100);
        SetServoPos(0, LAG, RAG);
        SetServoPos(0.25, LFA, RFA);
    }

    public void runOpMode() {
        Init();
        WaitForStart();
        if (opModeIsActive()) {
            move(1.0, -0.15, 1.23, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{1.0, 0.001, 0.03, 0.0}, new double[]{0.12, 0.001, 0.01, 0.0}, new double[]{0.06, 0.01, 0.015, 0.0}, 0.0001, High_Chamber);

            move(1.0, -0.15, 1.23, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.0, 0.00001, 0.3, 0.0}, new double[]{0.07, 0.0005, 0.001, 0.0}, new double[]{0.06, 0.001, 0.008, 0.0}, 0.0001, 1100);

            move(1.0, 0.72, 0.96, -125.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{0.8, 0.0032, 0.2, 0.0}, new double[]{0.07, 0.001, 0.009, 0.0}, new double[]{0.045, 0.001, 0.009, 0.0}, 0, 0);

            keep(0.45);

            move(1.0, 0.75, 0.7, -45.0, new double[]{0.15, 0.15, 0.15},
                    new double[]{0.8, 0.0007, 0.2, 0.0}, new double[]{0.07, 0.001, 0.009, 0.0}, new double[]{0.065, 0.001, 0.009, 0.0}, 0, 0);

            place();

            move(1.0, 1.15, 0.96, -125.0, new double[]{0.15, 0.15, 0.15},
                    new double[]{0.8, 0.0032, 0.2, 0.0}, new double[]{0.07, 0.001, 0.009, 0.0}, new double[]{0.065, 0.001, 0.009, 0.0}, 0, 0);

            keep(0.45);

            move(1.0, 0.95, 0.7, -45.0, new double[]{0.15, 0.15, 0.15},
                    new double[]{0.8, 0.0007, 0.2, 0.0}, new double[]{0.07, 0.001, 0.009, 0.0}, new double[]{0.055, 0.001, 0.009, 0.0}, 0, 0);

            place();

            SetServoPos(0, LAG, RAG);
            SetServoPos(0.25, LFA, RFA);

            while(true) {
                i++;
                plate = plate - 0.2;
                if (i > 3) break;
                move(1.0, 0.49, 0.49, -68.0, new double[]{0.15, 0.15, 0.15},
                        new double[]{0.6, 0.00001, 0.01, 0.0}, new double[]{0.07, 0.005, 0.001, 0.0}, new double[]{0.07, 0.005, 0.01, 0.0}, 0.001, 0);

                specimen();

//                SetServoPos(0.45, LLG, RLG);

                move(1.0, plate, 1.23, 0.0, new double[]{0.1, 0.15, 0.15},
                        new double[]{0.8, 0.001, 0.03, 0.0}, new double[]{0.09, 0.0001, 0.04, 0.0}, new double[]{0.05, 0.0001, 0.015, 0.0}, 0.0001, 720);

                SetServoPos(1, LLG, RLG);
                sleep(500);
                SetServoPos(0.25, D);
                sleep(400);
                SetServoPos(0, D);
            }

            SetServoPos(0, LLG, RLG);
            SetServoPos(0.5, LA, RA);
            SetServoPos(0, G);
            SetServoPos(0.25, AG);
            SetServoPos(0.3, D);
            SetServoPos(0.15, LAG, RAG);
            SetServoPos(0.7, LFA, RFA);

            move(1.0, 0.55, 0.35, -75.0, new double[]{0.12, 0.15, 0.15},
                    new double[]{1.0, 0.01, 0.3, 0.0}, new double[]{0.1, 0.01, 0.001, 0.0}, new double[]{0.1, 0.01, 0.009, 0.0}, 0.001, 0);






//            move(1.0, 1.2, 0.025, 180.0, new double[]{0.07, 0.15, 0.15},
//                    new double[]{1.2, 0.005, 0.3, 0.0}, new double[]{0.1, 0.0007, 0.001, 0.0}, new double[]{0.115, 0.009, 0.009, 0.0}, 0.001, 0);

//            move(1.0, -0.35, 1.245, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{2.2, 0.0007, 0.04, 0.0}, new double[]{0.1, 0.001, 0.01, 0.0}, new double[]{0.1, 0.001, 0.02, 0.0}, 0.0001, High_Chamber);
//
//            move(1.0, -0.35, 1.18, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{2.2, 0.00004, 0.02, 0.0}, new double[]{0.1, 0.005, 0.02, 0.0}, new double[]{0.1, 0.001, 0.002, 0.0}, 0.0001, 1100);
//
//            move(1.0, 1.2, 0.4, 180.0, new double[]{0.12, 0.15, 0.15},
//                    new double[]{1.2, 0.01, 0.3, 0.0}, new double[]{0.01, 0.0005, 0.001, 0.0}, new double[]{0.02, 0.0005, 0.009, 0.0}, 0.001, 0);
//
//            move(1.0, 1.2, 0.025, 180.0, new double[]{0.07, 0.15, 0.15},
//                    new double[]{1.2, 0.005, 0.3, 0.0}, new double[]{0.1, 0.0007, 0.001, 0.0}, new double[]{0.115, 0.009, 0.009, 0.0}, 0.001, 0);
//
//            move(1.0, -0.35, 1.245, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{2.2, 0.0007, 0.04, 0.0}, new double[]{0.12, 0.004, 0.01, 0.0}, new double[]{0.1, 0.001, 0.02, 0.0}, 0.0001, High_Chamber);
//
//            move(1.0, -0.35, 1.18, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{2.2, 0.0004, 0.02, 0.0}, new double[]{0.1, 0.0005, 0.02, 0.0}, new double[]{0.1, 0.0001, 0.002, 0.0}, 0.0001, 1100);
//
//            move(1.0, 1.2, 0.4, 180.0, new double[]{0.12, 0.15, 0.15},
//                    new double[]{1.2, 0.01, 0.3, 0.0}, new double[]{0.01, 0.0005, 0.001, 0.0}, new double[]{0.02, 0.0005, 0.009, 0.0}, 0.001, 0);
//
//            move(1.0, 1.2, 0.025, 180.0, new double[]{0.07, 0.15, 0.15},
//                    new double[]{1.2, 0.005, 0.3, 0.0}, new double[]{0.1, 0.0007, 0.001, 0.0}, new double[]{0.115, 0.009, 0.009, 0.0}, 0.001, 0);
//
//            move(1.0, -0.35, 1.245, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{2.2, 0.0007, 0.04, 0.0}, new double[]{0.12, 0.007, 0.01, 0.0}, new double[]{0.1, 0.001, 0.02, 0.0}, 0.0001, High_Chamber);
//
//            move(1.0, -0.35, 1.18, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{2.2, 0.00004, 0.02, 0.0}, new double[]{0.1, 0.005, 0.02, 0.0}, new double[]{0.1, 0.001, 0.002, 0.0}, 0.0001, 1100);
//
//            move(1.0, 1.47, 0.3, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{2.0, 0.0001, 0.3, 0.0}, new double[]{0.4, 0.001, 0.0007, 0.0}, new double[]{0.4, 0.0001, 0.0007, 0.0}, 0.001, 0);
        }
    }
}