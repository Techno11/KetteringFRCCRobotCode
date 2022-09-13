// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final SingleMotorSubsystem m_manipSubsystem = new SingleMotorSubsystem(Constants.INTAKE);
  private final SingleMotorSubsystem m_armSubsystem = new SingleMotorSubsystem(Constants.MANIP_LIFT);
  private final SingleMotorSubsystem m_liftSubsystem = new SingleMotorSubsystem(Constants.HANG);


  private final Joystick m_driveJoystick = new Joystick(0);
  private final Joystick m_auxJoystick = new Joystick(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, m_driveJoystick));

    m_armSubsystem.setDefaultCommand(new SingleMotorAnalogCommand(m_armSubsystem, m_auxJoystick, Constants.JS_Y, true, .5));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton aux5 = new JoystickButton(m_auxJoystick, 5); // Hang Up
    JoystickButton aux3 = new JoystickButton(m_auxJoystick, 3); // Hang Down

    JoystickButton aux1 = new JoystickButton(m_auxJoystick, 1); // Intake in
    JoystickButton aux2 = new JoystickButton(m_auxJoystick, 2); // Intake out

    aux5.whileHeld(new SingleMotorCommand(m_liftSubsystem, -1));
    aux3.whileHeld(new SingleMotorCommand(m_liftSubsystem, 1));

    aux1.whileHeld(new SingleMotorCommand(m_manipSubsystem, 1));
    aux2.whileHeld(new SingleMotorCommand(m_manipSubsystem, -1));
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
