package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {

  private final DriveTrain m_driveSubsystem = new DriveTrain();
  private final CommandXboxController m_driverController = new CommandXboxController(0);
  //private final Joystick m_joystick = new Joystick(1);
  
  public RobotContainer() {
    m_driveSubsystem.setDefaultCommand(
        new RunCommand(
            () -> m_driveSubsystem.arcadeDrive(
                -m_driverController.getRawAxis(1),
                -m_driverController.getRawAxis(4)
), m_driveSubsystem));
    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
