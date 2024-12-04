package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Sample")
public class Auto_Sample extends Robot {
    int i = 0;

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

    private void keep(double pos) {
        SetServoPos(0, LLG, RLG);
        SetServoPos(0.5, LA, RA);
        SetServoPos(pos, AG);
        SetServoPos(0, G);
        SetServoPos(0.15, LAG, RAG);
        SetServoPos(0.7, LFA, RFA);

        sleep(400);

        SetServoPos(0.3, G);
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

    public void runOpMode() {
        Init();

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

        WaitForStart();
        if (opModeIsActive()) {
            move(1.0, -0.15, 1.24, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.0, 0.00001, 0.03, 0.0}, new double[]{0.12, 0.0001, 0.01, 0.0}, new double[]{0.09, 0.00001, 0.015, 0.0}, 0.0001, High_Chamber);

            move(1.0, -0.15, 1.18, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.0, 0.00001, 0.3, 0.0}, new double[]{0.12, 0.001, 0.001, 0.0}, new double[]{0.12, 0.001, 0.008, 0.0}, 0.0001, 1100);

//            move(1.0, 1.0, 1.0, 0.0, new double[]{0.01, 0.1, 0.1},
//                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.1, 0.001, 0.0009, 0.0}, new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);
//
//            move(1.0, 1.0, 2.2, 0.0, new double[]{0.01, 0.1, 0.1},
//                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.1, 0.001, 0.0009, 0.0}, new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);
//
//            move(1.0, 1.4, 0.5, 0.0, new double[]{0.01, 0.05, 0.1},
//                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.7, 0.001, 0.015, 0.0},  new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);
//
//            move(1.0, 1.4, 2.2, 0.0, new double[]{0.01, 0.1, 0.1},
//                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.1, 0.001, 0.0009, 0.0}, new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);
//
//            move(1.0, 1.8, 0.5, 0.0, new double[]{0.01, 0.05, 0.1},
//                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.7, 0.001, 0.015, 0.0},  new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);

            move(1.0, 0.68, 0.96, -125.0, new double[]{0.15, 0.15, 0.2},
                    new double[]{1.0, 0.0007, 0.2, 0.0}, new double[]{0.05, 0.0005, 0.009, 0.0}, new double[]{0.02, 0.0001, 0.009, 0.0}, 0, 0);

            keep(0.45);

            move(1.0, 0.75, 0.7, -45.0, new double[]{0.17, 0.15, 0.2},
                    new double[]{1.0, 0.0007, 0.2, 0.0}, new double[]{0.04, 0.0001, 0.009, 0.0}, new double[]{0.02, 0.0001, 0.009, 0.0}, 0, 0);

            place();

            move(1.0, 1.05, 0.91, -125.0, new double[]{0.15, 0.15, 0.2},
                    new double[]{1.0, 0.0007, 0.2, 0.0}, new double[]{0.06, 0.0001, 0.009, 0.0}, new double[]{0.04, 0.0001, 0.009, 0.0}, 0, 0);

            keep(0.45);

            move(1.0, 0.95, 0.7, -45.0, new double[]{0.17, 0.15, 0.2},
                    new double[]{1.0, 0.0007, 0.2, 0.0}, new double[]{0.04, 0.0001, 0.009, 0.0}, new double[]{0.02, 0.0001, 0.009, 0.0}, 0, 0);

            place();

            move(1.0, 1.2, 0.4, 180.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{1.2, 0.02, 0.3, 0.0}, new double[]{0.05, 0.0001, 0.001, 0.0}, new double[]{0.02, 0.0001, 0.009, 0.0}, 0.001, 0);

            move(1.0, 1.2, 0.025, 180.0, new double[]{0.07, 0.15, 0.15},
                    new double[]{1.2, 0.005, 0.3, 0.0}, new double[]{0.1, 0.0007, 0.001, 0.0}, new double[]{0.099, 0.007, 0.009, 0.0}, 0.001, 0);

            move(1.0, -0.35, 1.22, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.2, 0.0007, 0.04, 0.0}, new double[]{0.1, 0.001, 0.01, 0.0}, new double[]{0.1, 0.001, 0.02, 0.0}, 0.0001, High_Chamber);

            move(1.0, -0.35, 1.18, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.2, 0.00004, 0.02, 0.0}, new double[]{0.1, 0.005, 0.02, 0.0}, new double[]{0.1, 0.001, 0.002, 0.0}, 0.0001, 1100);

            move(1.0, 1.2, 0.4, 180.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{1.2, 0.02, 0.3, 0.0}, new double[]{0.05, 0.0001, 0.001, 0.0}, new double[]{0.02, 0.0001, 0.009, 0.0}, 0.001, 0);

            move(1.0, 1.2, 0.025, 180.0, new double[]{0.07, 0.15, 0.15},
                    new double[]{1.2, 0.005, 0.3, 0.0}, new double[]{0.1, 0.0007, 0.001, 0.0}, new double[]{0.099, 0.007, 0.009, 0.0}, 0.001, 0);

//            move(1.0, 1.2, 0.3, 0.0, new double[]{0.1, 0.15, 0.15},
//                    new double[]{1.0, 0.001, 0.1, 0.0}, new double[]{0.1, 0.01, 0.01, 0.0}, new double[]{0.13, 0.01, 0.02, 0.0}, 0.0001, 300);

            move(1.0, -0.35, 1.22, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.2, 0.0007, 0.04, 0.0}, new double[]{0.12, 0.004, 0.01, 0.0}, new double[]{0.1, 0.001, 0.02, 0.0}, 0.0001, High_Chamber);

            move(1.0, -0.35, 1.18, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.2, 0.0004, 0.02, 0.0}, new double[]{0.1, 0.0005, 0.02, 0.0}, new double[]{0.1, 0.0001, 0.002, 0.0}, 0.0001, 1100);

            move(1.0, 1.2, 0.4, 180.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{1.2, 0.02, 0.3, 0.0}, new double[]{0.05, 0.0001, 0.001, 0.0}, new double[]{0.02, 0.0001, 0.009, 0.0}, 0.001, 0);

            move(1.0, 1.2, 0.025, 180.0, new double[]{0.07, 0.15, 0.15},
                    new double[]{1.2, 0.005, 0.3, 0.0}, new double[]{0.1, 0.0007, 0.001, 0.0}, new double[]{0.099, 0.007, 0.009, 0.0}, 0.001, 0);

            move(1.0, -0.35, 1.22, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.2, 0.0007, 0.04, 0.0}, new double[]{0.12, 0.007, 0.01, 0.0}, new double[]{0.1, 0.001, 0.02, 0.0}, 0.0001, High_Chamber);

            move(1.0, -0.35, 1.18, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.2, 0.00004, 0.02, 0.0}, new double[]{0.1, 0.005, 0.02, 0.0}, new double[]{0.1, 0.001, 0.002, 0.0}, 0.0001, 1100);

            move(1.0, 1.5, 0.3, 0.0, new double[]{0.1, 0.15, 0.15},
                    new double[]{2.0, 0.0001, 0.3, 0.0}, new double[]{0.4, 0.001, 0.0007, 0.0}, new double[]{0.4, 0.0001, 0.0007, 0.0}, 0.001, 0);
        }
    }
}