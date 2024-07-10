package frc.robot.subsystems;

import javax.swing.text.Position;

import edu.wpi.first.hal.PWMConfigDataResult;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwingServo extends SubsystemBase {
    public final static Servo basil = new Servo(Constants.SERVO);
    public boolean Star = false;
    public double angle = 180;
    double xc;
    int counter = 0;
    double currentAngle = 0;
    int direction = 1;
    double xcc;

    public SwingServo() {
        Reset();
    }

    public void Reset() {  
        basil.setAngle(Constants.ServoMid);
        xc = basil.getAngle();
        Star = true;
        angle = 180;
        currentAngle = 0;
        direction = 1;
    }

    public void Search2() {
        if (Star) {
            counter += 1;
            if (counter % 10 == 0) {
                if (currentAngle > 180) {
                    direction = -1;
                }
                else if (currentAngle < 0) {
                    direction = 1;
                }
                xcc = currentAngle+(1*direction);
                basil.setAngle(xcc);
                currentAngle = xcc;
                
            }
        }
    }

    public void Search() {
        if (Star) {
            counter += 1;
            if (counter % 50 == 0) {
                // xc = basil.getAngle();
                if (xc >= 142) {
                    angle = 62;
                }
                else if (xc <= 62) {
                    angle = 142;
                }

                // xc = basil.getAngle();
                basil.setAngle(angle);
                xc = basil.getAngle();
                // basil.setSpeed(speed);
            }

        }
        
        
    }

    public void ServoDebugger() {
        System.out.println("Prelim Data:");
        System.out.println("get " + basil.get() + " getHandle " + basil.getHandle() + " getSpeed " + basil.getSpeed() + " getChannel " + basil.getChannel());
        System.out.println("boundsmicrseonds " + basil.getBoundsMicroseconds() + " Pulsemicroseconds " + basil.getPulseTimeMicroseconds() + " getAngle" + basil.getAngle());
        System.out.println("end of prelim data");

        System.out.println("After Data:");
        System.out.println("get " + basil.get() + " getHandle " + basil.getHandle() + " getSpeed " + basil.getSpeed() + " getChannel " + basil.getChannel());
        System.out.println("boundsmicrseonds " + basil.getBoundsMicroseconds() + " Pulsemicroseconds " + basil.getPulseTimeMicroseconds() + " getAngle" + basil.getAngle());
        System.out.println("end of After data");
    }

    @Override
    public void periodic() {
        // Search(0.1);
    }
    
}

