package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends SubsystemBase {

    private final WPI_VictorSPX leftMaster = new WPI_VictorSPX(1);
    private final WPI_VictorSPX leftFollower = new WPI_VictorSPX(2);
    private final WPI_VictorSPX rightMaster = new WPI_VictorSPX(7);
    private final WPI_VictorSPX rightFollower = new WPI_VictorSPX(12);

    private final DifferentialDrive drive;

    public DriveTrain() {
        leftMaster.configFactoryDefault();
        leftFollower.configFactoryDefault();
        rightMaster.configFactoryDefault();
        rightFollower.configFactoryDefault();

        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);

        leftMaster.setInverted(false);
        leftFollower.setInverted(false); 
        rightMaster.setInverted(true);
        rightFollower.setInverted(true);

        configureMotorSafety(leftMaster);
        configureMotorSafety(leftFollower);
        configureMotorSafety(rightMaster);
        configureMotorSafety(rightFollower);

        drive = new DifferentialDrive(leftMaster, rightMaster);
    }

    private void configureMotorSafety(WPI_VictorSPX victor) {
        victor.configOpenloopRamp(0.1);

        victor.setNeutralMode(NeutralMode.Brake);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    @Override
    public void periodic() {
    }
}
