// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AuxCommand;
import frc.robot.commands.AuxCommandTriggers;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.AuxSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
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
  private final AuxSubsystem m_aux1 = new AuxSubsystem(Constants.Aux1);
  private final AuxSubsystem m_aux2 = new AuxSubsystem(Constants.Aux2);
  private final AuxSubsystem m_aux3 = new AuxSubsystem(Constants.Aux3);

  // Joystick
  private final Joystick m_joystick = new Joystick(0);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set Default Commands
    setDefaultCommands();
  }

  // Set Subsystem Default Commands
  public void setDefaultCommands() {
    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, m_joystick));

    m_aux2.setDefaultCommand(new AuxCommandTriggers(m_aux2, m_joystick));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton a = new JoystickButton(m_joystick, Constants.JS_A);
    a.whileHeld(new AuxCommand(m_aux1, -.75));

    
    JoystickButton y = new JoystickButton(m_joystick, Constants.JS_Y);
    y.whileHeld(new AuxCommand(m_aux1, .75));

    JoystickButton lb = new JoystickButton(m_joystick, Constants.JS_LB);
    lb.whileHeld(new AuxCommand(m_aux3, -.75));

    JoystickButton rb = new JoystickButton(m_joystick, Constants.JS_RB);
    rb.whileHeld(new AuxCommand(m_aux3, -.75));
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
