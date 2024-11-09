package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Auto_Bucket", group = "In")
public class Auto_Bucket extends Robot {

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
            move(-1.3, 0.85, 200.0, new double[]{0.4, 0.001, 0.05},
                    new double[]{2.0, 0.0001, 0.3, 0.0}, new double[]{0.12, 0.01, 0.007, 0.0}, new double[]{0.07, 0.008, 0.009, 0.0}, 1.0, 4800);

            move(-1.3, 2.5, 120.0, new double[]{0.07, 0.001, 0.009},
                    new double[]{2.0, 0.001, 0.3, 0.0}, new double[]{0.08, 0.01, 0.007, 0.0}, new double[]{0.07, 0.0005, 0.009, 0.0}, 0, 1500);

            move(-0.25, 2.1, 90.0, new double[]{0.4, 0.001, 0.05},
                    new double[]{3.0, 0.001, 0.8, 0.0}, new double[]{0.25, 0.01, 0.07, 0.0}, new double[]{0.1, 0.00001, 0.0001, 0.0}, 0.01, 1500); // park
        }
    }
}