// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.GenericCommandGroups.IntakeIndexNoShoot;
import frc.robot.commands.GenericCommandGroups.IntakeIndexShoot;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ClimberSubsystem m_ClimberSubsystem = new ClimberSubsystem();
  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  private final IndexerSubsystem m_IndexerSubsystem = new IndexerSubsystem();
  private final IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();

  // Joystick
  private final XboxController m_DriverStick = new XboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set Default Commands
    setDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // A/B - Climber Up/Down
    JoystickButton a = new JoystickButton(m_DriverStick, XboxController.Button.kA.value);
    JoystickButton b = new JoystickButton(m_DriverStick, XboxController.Button.kB.value);

    a.whileHeld(new ClimbCommand(m_ClimberSubsystem, 1));
    b.whileHeld(new ClimbCommand(m_ClimberSubsystem, -1));

    // Y - Indexer/Shooter/Intake Reverse
    JoystickButton y = new JoystickButton(m_DriverStick, XboxController.Button.kY.value);  
    y.whileHeld(new IntakeIndexShoot(m_IntakeSubsystem, m_IndexerSubsystem, m_ShooterSubsystem, -.5, -.5, -.4, false));

    // X - Bottom Index / Intake
    JoystickButton x = new JoystickButton(m_DriverStick, XboxController.Button.kX.value);
    x.whileHeld(new IntakeIndexNoShoot(m_IntakeSubsystem, m_IndexerSubsystem, 1, .5, true));

    // Left Bumper - Full System Intake (Feed Shooter)
    JoystickButton lb = new JoystickButton(m_DriverStick, XboxController.Button.kLeftBumper.value);
    lb.whileHeld(new IntakeIndexNoShoot(m_IntakeSubsystem, m_IndexerSubsystem, 1, .5, false));

    // Right Bumper - Shoot
    JoystickButton rb = new JoystickButton(m_DriverStick, XboxController.Button.kRightBumper.value);
    rb.whileHeld(new ShooterCommand(m_ShooterSubsystem, 1));
  }

  private void setDefaultCommands() {
    m_DriveSubsystem.setDefaultCommand(new DriveCommand(m_DriveSubsystem, m_DriverStick));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
