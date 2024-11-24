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

    private void clips() {
        SetServoPos(1, LLG, RLG); // 0.7
        sleep(1000);

        SetServoPos(0.2, D);
        sleep(100);
        SetServoPos(0, LLG, RLG);
    }

    public void runOpMode() {
        Init();

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

        WaitForStart();
        if (opModeIsActive()) {
            move(1.0, -0.15, 1.19, 0.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{2.0, 0.01, 0.03, 0.0}, new double[]{0.06, 0.05, 0.0005, 0.0}, new double[]{0.08, 0.05, 0.01, 0.0}, 0.0001, 1700);

            move(1.0, -0.15, 1.19, 0.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.1, 0.1, 0.01, 0.0}, new double[]{0.1, 0.1, 0.008, 0.0}, 0.0001, 1100);

            move(1.0, 1.0, 1.19, 0.0, new double[]{0.1, 0.1, 0.1},
                    new double[]{2.0, 0.1, 0.2, 0.0}, new double[]{0.1, 0.001, 0.009, 0.0}, new double[]{0.2, 0.0001, 0.009, 0.0}, 0, 0);



            move(1.0, 1.0, 2.2, 0.0, new double[]{0.01, 0.1, 0.1},
                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.1, 0.01, 0.0009, 0.0}, new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);

            move(1.0, 1.4, 0.5, 0.0, new double[]{0.01, 0.05, 0.1},
                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.7, 0.1, 0.015, 0.0},  new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);

            move(1.0, 1.4, 2.2, 0.0, new double[]{0.01, 0.1, 0.1},
                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.1, 0.01, 0.0009, 0.0}, new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);

            move(1.0, 1.8, 0.5, 0.0, new double[]{0.01, 0.05, 0.1},
                    new double[]{2.0, 0.08, 0.1, 0.0}, new double[]{0.7, 0.1, 0.015, 0.0},  new double[]{0.09, 0.0001, 0.01, 0.0}, 0, 0);



            move(1.0, 1.2, 0.4, 180.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.05, 0.07, 0.001, 0.0}, new double[]{0.08, 0.00001, 0.009, 0.0}, 0.001, 0);

            move(1.0, 1.2, 0.05, 180.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.09, 0.07, 0.03, 0.0}, new double[]{0.16, 0.00001, 0.012, 0.0}, 0.001, 0);



            move(1.0, -0.35, 1.2, 0.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{3.0, 0.0001, 0.04, 0.0}, new double[]{0.09, 0.001, 0.001, 0.0}, new double[]{0.06, 0.001, 0.002, 0.0}, 0.0001, 1600);

            move(1.0, -0.35, 1.2, 0.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{3.0, 0.0001, 0.02, 0.0}, new double[]{0.04, 0.5, 0.02, 0.0}, new double[]{0.06, 0.001, 0.002, 0.0}, 0.0001, 1100);

            move(1.0, 1.2, 0.4, 180.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.09, 0.07, 0.001, 0.0}, new double[]{0.08, 0.00001, 0.009, 0.0}, 0.001, 0);

            move(1.0, 1.2, 0.05, 180.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.09, 0.01, 0.06, 0.0}, new double[]{0.16, 0.00001, 0.012, 0.0}, 0.001, 0);



            move(1.0, -0.45, 1.2, 0.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{3.0, 0.0001, 0.04, 0.0}, new double[]{0.09, 0.001, 0.001, 0.0}, new double[]{0.06, 0.0001, 0.002, 0.0}, 0.0001, 1600);

            move(1.0, -0.45, 1.2, 0.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{3.0, 0.0001, 0.02, 0.0}, new double[]{0.09, 0.0002, 0.02, 0.0}, new double[]{0.09, 0.0001, 0.002, 0.0}, 0.0001, 1100);

//            move(1.0, 1.0, 0.4, 180.0, new double[]{0.25, 0.5, 0.5},
//                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.12, 0.01, 0.005, 0.0}, new double[]{0.1, 0.1, 0.01, 0.0}, 0.001, 0);
//
//            move(1.0, 1.0, 0.07, 180.0, new double[]{0.25, 0.55, 0.55},
//                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{2.0, 0.01, 0.06, 0.0}, new double[]{0.17, 0.1, 0.01, 0.0}, 0.001, 0);
//
//            move(1.0, -0.45, 1.19, 0.0, new double[]{1.0, 0.5, 0.5},
//                    new double[]{2.0, 0.1, 0.2, 0.0}, new double[]{0.17, 0.1, 0.005, 0.0}, new double[]{0.2, 0.1, 0.009, 0.0}, 0.0001, 1800);
//
//            move(1.0, -0.45, 1.19, 0.0, new double[]{1.0, 0.5, 0.5},
//                    new double[]{2.0, 0.1, 0.2, 0.0}, new double[]{0.3, 0.2, 0.02, 0.0}, new double[]{0.17, 0.2, 0.02, 0.0}, 0.0001, 1100);

            move(1.0, 1.5, 0.3, 0.0, new double[]{0.05, 0.1, 0.1},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.15, 0.0001, 0.007, 0.0}, new double[]{0.15, 0.0001, 0.007, 0.0}, 0.001, 0);

//            SetServoPos(0, LLG, RLG);
//            SetServoPos(0.5, LA, RA);
//            SetServoPos(0.15, G);
//            SetServoPos(0.2, D);
//            SetServoPos(0.15, LAG, RAG);
//            SetServoPos(0.73, LFA, RFA);
//            sleep(1000);

        }
    }
}