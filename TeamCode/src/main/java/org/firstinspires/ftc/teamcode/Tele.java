package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Utilize.WrapRads;
import static org.firstinspires.ftc.teamcode.Utilize.toRadian;
import static org.firstinspires.ftc.teamcode.Utilize.toDegree;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import java.util.Set;

@TeleOp(name="Tele")
public class Tele extends Robot {

    private Controller controller;

    // Variables
    int Level, CurrentPosition = 0;
    double setpoint = 0, AL_Ang = 0, ArmPos = 0, LiftPos = 0;
    boolean kp = false, ls = false, On = false, ag = false, press_ag = false, press = false, r_disable = false, Left_isTouch = false, Right_isTouch = false,  Auto_Lift = false, x_press = false, Auto_Arm = false;
    double CurrentTime = System.nanoTime() * 1E-9,  lastRXtime = CurrentTime;
    private void Init() {
        // Initialize Robot
        Initialize(DcMotor.RunMode.RUN_WITHOUT_ENCODER, new double[]{0, 0, AL_Ang},
                                                        new double[]{0, 0, 0, 0});
        SetServoPos(0, G, AG);
        SetServoPos(0, LA, RA);
        SetServoPos(0, LFA, RFA);
        SetServoPos(0, LAG, RAG);
        SetServoPos(0, LLG, RLG);
        SetServoPos(0, D);
        controller = new Controller(1.2, 0.005, 0.1, 0 , 0.15, toRadian(0.75));

        setpoint = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }

    private void Movement() {
        CurrentTime    = System.nanoTime() * 1E-9;
        double lift    = Math.max(LL.getCurrentPosition(), RL.getCurrentPosition());
        double speed   = 0.275;
        double lx      = gamepad1.left_stick_x;
        double ly      = -gamepad1.left_stick_y;
        double x1      = gamepad1.dpad_left ? -speed : gamepad1.dpad_right ? speed : lx;
        double y1      = gamepad1.dpad_up ? speed : gamepad1.dpad_down ? -speed : ly;
        double yaw     = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double heading = -yaw;
        double x2 = (Math.cos(heading) * x1) - (Math.sin(heading) * y1);
        double y2 = (Math.sin(heading) * x1) + (Math.cos(heading) * y1);
        // Rotate
        double r = r_disable ? 0 : controller.Calculate(WrapRads(yaw - setpoint));
        double x = gamepad1.right_stick_x;

        if (x != 0 || CurrentTime - lastRXtime < 0.45) {
            r = x;
            setpoint = yaw;
        }

        if (lx == 0 && ly == 0 && x== 0 && Math.abs(r) < 0.2)  r = 0;
        lastRXtime = x != 0 ? CurrentTime : lastRXtime;
        // Denominator for division to get no more than 1
        double d = Math.max(Math.abs(x2) + Math.abs(y2) + Math.abs(r), 1);
        // Lift limit speed
        double l = lift > High_Basket - 1000 ? 0.5 : lift > 850 ? 0.8 : ls ? 0.6 : 1;

        MovePower(((y2 + x2 + r) / d) * l, ((y2 - x2 - r) / d) * l,
                  ((y2 - x2 + r) / d) * l, ((y2 + x2 - r) / d) * l);
        telemetry.addData("yaw", toDegree(yaw));
        telemetry.addData("setpoint", toDegree(setpoint));
//        telemetry.addData("error", controller.Error);
    }

    private void Lift() {
        double LT = gamepad2.left_trigger;
        double RT = gamepad2.right_trigger;
        double CurPos = Math.max(LL.getCurrentPosition(), RL.getCurrentPosition());
        boolean du = gamepad2.dpad_up;
        boolean dl = gamepad2.dpad_left;
        boolean dd = gamepad2.dpad_down;
        Left_isTouch  = LTS.isPressed();
        Right_isTouch = RTS.isPressed();

        if (du) SetServoPos(1, LLG, RLG);
//        if (dl) SetServoPos(0.9, LLG, RLG);
        if (dd) SetServoPos(0, LLG, RLG);

        if (Left_isTouch) {
            LL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
        if (gamepad2.x) {
            Auto_Lift = true;
            LiftPos = High_Chamber;
            SetServoPos(0, LLG, RLG);
        }
        if (gamepad2.y) {
            Auto_Lift = true;
            LiftPos = High_Basket;
        }
        if (gamepad2.b) {
            Auto_Lift = true;
            LiftPos = 0;
            SetServoPos(0, LLG, RLG);
        }
        if (gamepad2.a) {
            while (true) {
                Lift_SetPower(-0.1, -0.1);
            }
        }
        if (LT > 0 || Auto_Lift) {
            LL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

//        double Pos = Auto_Arm && LT < 0.5 ? arm : (Math.max(LL.getCurrentPosition(), RL.getCurrentPosition()) > LiftPos - 500 ? 1 : 0);
        double sp = LT > 0.25 ? LT : RT > 0.25 ? -RT : 0;

        double power = Auto_Lift ? ((CurPos < (LiftPos + 50) && CurPos > (LiftPos - 50)) ? 0 : CurPos > LiftPos ? -0.8 : 1) :
                     (Left_isTouch  && RT > 0.25 ? 0 : CurPos > High_Basket && LT > 0.25 ? 0 : sp);

        Lift_SetPower(power, power);

//        if (spL == 0 && spR == 0) {
//            LL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            RL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
        if (CurPos < (LiftPos + 20) && CurPos > (LiftPos - 20)) Auto_Lift = false;

        telemetry.addData("Lift", CurPos);
    }

    private void FrontArm() {
        boolean tp = gamepad1.a;
        boolean lb = gamepad1.left_bumper;
        boolean rb = gamepad1.right_bumper;
        double  lt = gamepad1.left_trigger;
        double  rt = gamepad1.right_trigger;

        if (lt > 0.5) {
            ArmPos = ArmPos - 0.005;
            ArmPos = Range.clip(ArmPos, 0, 0.5);
            SetServoPos(ArmPos, LA, RA);
        }
        if (rt > 0.5) {
            SetServoPos(0, LLG, RLG);
            SetServoPos(0.5, LA, RA);
            SetServoPos(0.2, G);
            SetServoPos(0.3, D);
            SetServoPos(0.15, LAG, RAG);
            SetServoPos(0.61, LFA, RFA);
            ArmPos = 0.5;
            On = true;
            ls = true;
            kp = false;
        }

        if (lb && On) SetServoPos(0.61, LFA, RFA);
        if (rb && On) SetServoPos(0.70, LFA, RFA);

        if (!(tp)) {
            press = false;
            return;
        }
        if (press) return;
        press = true;
        if (!On) {
            SetServoPos(0.15, G);
            SetServoPos(0.15, LAG, RAG);
            SetServoPos(0.61, LFA, RFA);
            SetServoPos(0.2, D);
            On = true;
            ls = true;
            return;
        }
        Sleep();
        SetServoPos(0, G);
        sleep(100);
        SetServoPos(1, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        sleep(150);
        SetServoPos(0, AG);
        SetServoPos(0, LA, RA);
        sleep(250);
        SetServoPos(0, D);
        sleep(100);
        SetServoPos(0.2, G);
        sleep(100);
        SetServoPos(0, LAG, RAG);
        ArmPos = 0;
        On = false;
        ls = false;
        press_ag = false;
        ag = false;
    }

    private void AdjustGripper() {
        boolean cr = gamepad1.y;

        if (!(cr)) {
            press_ag = false;
            return;
        }
        if (press_ag) return;
        press_ag = true;
        if (!ag) {
            SetServoPos(0.32, AG);
            ag = true;
            return;
        }
        SetServoPos(0, AG);
        ag = false;
    }

    private void PlaceElement() {
        boolean sq = gamepad1.x;

        if (!(sq)) {
            x_press = false;
            return;
        }
        if (x_press) return;
        x_press = true;
        if (!kp) {
            Sleep();
            SetServoPos(0, G);
            sleep(150);
            SetServoPos(0, LFA, RFA);
            sleep(100);
            SetServoPos(0, AG);
            SetServoPos(0, LA, RA);
            SetServoPos(0, LAG, RAG);
            ls = false;
            ag = false;
            kp = true;
            On = false;
            return;
        }
        Sleep();
        SetServoPos(0.5, LA, RA);
        SetServoPos(0.15, LAG, RAG);
        SetServoPos(0.69, LFA, RFA);
        sleep(300);
        SetServoPos(0.3, G);
        sleep(300);
        SetServoPos(0, LA, RA);
        SetServoPos(0, LAG, RAG);
        SetServoPos(0, LFA, RFA);
        SetServoPos(0, AG);
        kp = false;
        ls = false;
        ag = false;
        On = false;
    }

    private void drop() {
        boolean lb_press = gamepad2.left_bumper;
        boolean rb_press = gamepad2.right_bumper;

        if (lb_press) SetServoPos(0, D);
        if (rb_press) SetServoPos(0.25, D);
    }

    @Override
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

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                Odomentry();
                Movement();
                Lift();
                FrontArm();
                AdjustGripper();
                PlaceElement();
                drop();
//                telemetry.addData("XYH", "%6f cm %6f cm", Posx, Posy);
//                telemetry.addData("LeftLift" , "%d", LL.getCurrentPosition());
//                telemetry.addData("RightLift", "%d", RL.getCurrentPosition());
//                telemetry.addData("LRM", "%6d  %6d %6d", left_encoder_pos, right_encoder_pos, center_encoder_pos);
//                telemetry.addData("heading", toDegree(heading));
//                telemetry.addData("XYH", "%6f cm %6f cm", Posx, Posy);
                telemetry.update();
                if(gamepad1.options){
                    imu.resetYaw();
                    setpoint = 0;
                }
            }
        }
    }
}

