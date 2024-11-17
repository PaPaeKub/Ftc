package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Element")
public class Auto_Element extends Robot {

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
            move(0.4, -0.4, 1.2, 0.0, new double[]{0.4, 0.001, 0.05},
                    new double[]{2.0, 0.0001, 0.3, 0.0}, new double[]{0.12, 0.01, 0.007, 0.0}, new double[]{0.07, 0.008, 0.009, 0.0}, 1.0, High_Chamber);
//
//            move(2.1, 0.85, 120.0, new double[]{0.07, 0.001, 0.009},
//                    new double[]{2.0, 0.001, 0.3, 0.0}, new double[]{0.08, 0.01, 0.007, 0.0}, new double[]{0.07, 0.0005, 0.009, 0.0}, 0);
        }
    }
}