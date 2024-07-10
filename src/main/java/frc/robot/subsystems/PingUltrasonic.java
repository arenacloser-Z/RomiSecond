package frc.robot.subsystems;

import java.util.concurrent.DelayQueue;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PingUltrasonic extends SubsystemBase {
    AnalogInput cyril = new AnalogInput(Constants.AnalogPort);
    double b;
    double dist;
    int counter = 0;

    public PingUltrasonic() {
        Reset();
    }

    public void Reset() {
        counter = 0;
    }

    public void Ping() {
        b = cyril.getVoltage();
        dist = Constants.max_range*(b/Constants.voltage);
        System.out.println(dist + "\n\n\n");
        // return dist;
    }

    public void PingPeriodic() {
        counter += 1;
        if (counter % 50 == 0) {
            // System.out.println(Ping());
            Ping();
        }
    }
}
