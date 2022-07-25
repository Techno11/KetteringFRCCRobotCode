/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ClimberCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeLiftCommand;
import frc.robot.commands.IntakeRollerCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.OneMotorSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final OneMotorSubsystem m_intakeLift =  new OneMotorSubsystem(Constants.IntakeConstants.kIntakeLiftMotor);
  private final OneMotorSubsystem m_intakeRoll =  new OneMotorSubsystem(Constants.IntakeConstants.kIntakeRollerMotor);
  private final OneMotorSubsystem m_climber =  new OneMotorSubsystem(Constants.ClimbConstants.kClimbMotor);

  // The autonomous routines

  // A simple auto routine that drives forward a specified distance, and then stops.
  private final Command m_simpleAuto = new StartEndCommand(
      // Start driving forward at the start of the command
      () -> m_robotDrive.arcadeDrive(AutoConstants.kAutoDriveSpeed, 0),
      // Stop driving at the end of the command
      () -> m_robotDrive.arcadeDrive(0, 0),
      // Requires the drive subsystem
      m_robotDrive)
      // Set how long command will run
      .withTimeout(AutoConstants.kAutoDriveTime);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  // The driver's controller
  XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  //XboxController m_operatorController = new XboxController(OIConstants.kOperatorControllerPort);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set default commands
    setDefaultCommands();

    // Add commands to the autonomous command chooser
    m_chooser.setDefaultOption("Simple Auto", m_simpleAuto);

    // Put the chooser on the dashboard
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Bumpers trigger intake rollers
    JoystickButton leftBumper = new JoystickButton(m_driverController, Button.kLeftBumper.value);
    JoystickButton rightBumper = new JoystickButton(m_driverController, Button.kRightBumper.value);

    leftBumper.whileHeld(new IntakeRollerCommand(m_intakeRoll, -1));
    rightBumper.whileHeld(new IntakeRollerCommand(m_intakeRoll, 1));

    // A/B trigger climber
    JoystickButton a = new JoystickButton(m_driverController, Button.kA.value);
    JoystickButton b = new JoystickButton(m_driverController, Button.kB.value);

    a.whileHeld(new ClimberCommand(m_climber, 1));
    b.whileHeld(new ClimberCommand(m_climber, -1));
  }

  private void setDefaultCommands() {
    m_robotDrive.setDefaultCommand(new DriveCommand(m_robotDrive, m_driverController));

    m_intakeLift.setDefaultCommand(new IntakeLiftCommand(m_intakeLift, m_driverController));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}
