package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Bucket", group = "In")
public class Auto_Bucket extends Robot {

    private void keep() {
        SetServoPos(0.5, LA, RA);
        SetServoPos(0.2, G);
        SetServoPos(0.3, D);
        SetServoPos(0.15, LAG, RAG);
        SetServoPos(0.65, LFA, RFA);

        sleep(1000);

        SetServoPos(0, G);
        sleep(200);
        SetServoPos(1, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        sleep(200);
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
        SetServoPos(1, LLG, RLG);

        sleep(1000);

        SetServoPos(0.3, D);

        sleep(500);

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
        WaitForStart();
        if (opModeIsActive()) {
            move(1.0, -0.6, 0.3, 215.0, new double[]{0.4, 0.008, 0.1},
                    new double[]{2.0, 0.004, 0.7, 0.0}, new double[]{0.2, 0.01, 0.015, 0.0}, new double[]{0.15, 0.004, 0.01, 0.0}, 1.0, High_Basket);
            sleep(10000);
//            keep();
//
//            move(1.0, -0.8, 0.7, 215.0, new double[]{0.4, 0.008, 0.1},
//                    new double[]{2.0, 0.004, 0.7, 0.0}, new double[]{0.2, 0.01, 0.015, 0.0}, new double[]{0.15, 0.004, 0.01, 0.0}, 1.0, High_Basket);
//            move(0.4, -1.3, 2.5, 90.0, new double[]{0.07, 0.001, 0.009},
//                    new double[]{2.0, 0.001, 0.3, 0.0}, new double[]{0.08, 0.01, 0.007, 0.0}, new double[]{0.07, 0.0005, 0.009, 0.0}, 0, 1500);
//
//            move(0.4, -0.25, 2.1, 90.0, new double[]{0.4, 0.001, 0.05},
//                    new double[]{3.0, 0.001, 0.8, 0.0}, new double[]{0.25, 0.01, 0.07, 0.0}, new double[]{0.1, 0.00001, 0.0001, 0.0}, 0.01, 1500); // park
        }
    }
}