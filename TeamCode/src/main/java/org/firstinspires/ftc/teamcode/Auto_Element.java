package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Set;

@Autonomous(name="Auto_Element")
public class Auto_Element extends Robot {
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
        SetServoPos(0.6, LLG, RLG);

        LL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        WaitForStart();
        if (opModeIsActive()) {
            move(1.0, -0.15, 1.19, 0.0, new double[]{0.25, 0.5, 0.5},
                    new double[]{2.0, 0.0001, 0.3, 0.0}, new double[]{0.09, 0.01, 0.005, 0.0}, new double[]{0.075, 0.01, 0.01, 0.0}, 0.1, 1800);

            move(1.0, -0.15, 1.19, 0.0, new double[]{0.35, 0.5, 0.5},
                    new double[]{2.0, 0.0001, 0.3, 0.0}, new double[]{0.09, 0.0001, 0.001, 0.0}, new double[]{0.09, 0.001, 0.001, 0.0}, 0.0001, 1100);

            move(1.0, 1.0, 1.0, 0.0, new double[]{0.35, 0.35, 0.35},
                    new double[]{3.0, 0.1, 0.6, 0.0}, new double[]{1.0, 0.01, 0.08, 0.0}, new double[]{0.15, 0.001, 0.0001, 0.0}, 0.0001, 0);



            move(1.0, 1.0, 2.4, 0.0, new double[]{0.25, 0.35, 0.35},
                    new double[]{2.0, 0.001, 0.3, 0.0}, new double[]{1.0, 0.001, 0.03, 0.0}, new double[]{0.1, 0.00001, 0.0075, 0.0}, 0, 0);

            move(1.0, 1.4, 0.5, 0.0, new double[]{0.25, 0.35, 0.35},
                    new double[]{2.0, 0.001, 0.3, 0.0}, new double[]{2.0, 0.01, 0.06, 0.0}, new double[]{0.1, 0.00001, 0.0075, 0.0}, 0, 0);

            move(1.0, 1.4, 2.4, 0.0, new double[]{0.25, 0.35, 0.35},
                    new double[]{2.0, 0.001, 0.3, 0.0}, new double[]{1.0, 0.0001, 0.03, 0.0}, new double[]{0.1, 0.00001, 0.0075, 0.0}, 0, 0);

            move(1.0, 1.8, 0.5, 0.0, new double[]{0.25, 0.35, 0.35},
                    new double[]{2.0, 0.001, 0.3, 0.0}, new double[]{2.0, 0.01, 0.06, 0.0}, new double[]{0.1, 0.00001, 0.0075, 0.0}, 0, 0);



            move(1.0, 1.0, 0.4, 180.0, new double[]{0.35, 0.5, 0.5},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.09, 0.01, 0.005, 0.0}, new double[]{0.075, 0.01, 0.01, 0.0}, 0.1, 0);

            move(1.0, 1.0, 0.09, 180.0, new double[]{0.35, 0.55, 0.55},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{2.0, 0.01, 0.06, 0.0}, new double[]{0.15, 0.01, 0.0007, 0.0}, 0, 0);



            move(1.0, -0.25, 1.19, 0.0, new double[]{0.5, 0.5, 0.5},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.15, 0.01, 0.005, 0.0}, new double[]{0.15, 0.01, 0.01, 0.0}, 0.1, 1800);

            move(1.0, -0.25, 1.19, 0.0, new double[]{0.35, 0.5, 0.5},
                    new double[]{2.0, 0.1, 0.3, 0.0}, new double[]{0.12, 0.01, 0.009, 0.0}, new double[]{0.15, 0.01, 0.009, 0.0}, 0.0001, 1100);

//
//            SetServoPos(0.72, LLG, RLG);
//            SetServoPos(0.2, D);
//
//            move(1.0, 1.0, 1.0, 180.0, new double[]{0.35, 0.35, 0.35},
//                    new double[]{2.0, 0.001, 0.009, 0.0}, new double[]{0.09, 0.001, 0.009, 0.0}, new double[]{0.09, 0.0001, 0.009, 0.0}, 0.1, 0);
//
//            move(0.4, 1.0, 0.25, 180.0, new double[]{0.35, 0.35, 0.35},
//                    new double[]{1.0, 0.0001, 0.009, 0.0}, new double[]{0.01, 0.001, 0.001, 0.0}, new double[]{0.09, 0.0001, 0.001, 0.0}, 0.00001, 0);

//            move(0.4, 2.15, 0.4, 180.0, new double[]{0.4, 0.001, 0.05},
//                    new double[]{4.0, 0.01, 0.8, 0.0}, new double[]{0.12, 0.01, 0.4, 0.0}, new double[]{0.15, 0.008, 0.0001, 0.0}, 0.1, 0);

        }
    }
}