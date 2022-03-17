// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.commands.AutonGroups.DropAndMoveBack;
import frc.robot.commands.AutonGroups.TwoBallGyro;
import frc.robot.commands.AutonGroups.TwoBallTimed;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ManipSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ManipSubsystem m_manipSubsystem = new ManipSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();

  // Joystick
  private final Joystick driverJoystick = new Joystick(0);
  private final Joystick auxJoystick = new Joystick(1);

  // Gyro
  private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set default commands
    setDefaultCommands();

    // Configure Autonomous Modes
    configAutonModes();

    // Calibrate Gyro
    this.gyro.calibrate();
  }

  private void configAutonModes() {
    // Add commands to the autonomous command chooser
    m_chooser.setDefaultOption("Drop and Drive Back (Center Starting Position)", new DropAndMoveBack(m_driveSubsystem, m_manipSubsystem, m_intakeSubsystem));
    m_chooser.addOption("Two Ball Gyro (Side Starting Positions)", new TwoBallGyro(m_driveSubsystem, m_manipSubsystem, m_intakeSubsystem, gyro));
    m_chooser.addOption("Two Ball Timed (Less Reliable)", new TwoBallTimed(m_driveSubsystem, m_manipSubsystem, m_intakeSubsystem));

    // Put the chooser on the dashboard
    SmartDashboard.putData("Autonomous Selector", m_chooser);
  }

  private void setDefaultCommands() {
    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, driverJoystick));
    m_manipSubsystem.setDefaultCommand(new LiftCommand(m_manipSubsystem, auxJoystick));
    m_intakeSubsystem.setDefaultCommand(new IntakeCommand(m_intakeSubsystem, auxJoystick));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  public Rotation2d getHeading() {
    return this.gyro.getRotation2d();
  }
}
