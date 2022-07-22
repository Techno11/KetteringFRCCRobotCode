// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {
  private final Drivetrain m_subsystem;
  private final Joystick driveJoystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDrive(Drivetrain subsystem, Joystick driveJoystick) {
    m_subsystem = subsystem;
    this.driveJoystick = driveJoystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double yInput = driveJoystick.getRawAxis(Constants.LEFT_Y) * .75;
    double xInput = driveJoystick.getRawAxis(Constants.RIGHT_X) * .75; // Slow down turning speed

    // Send to subsystem
    m_subsystem.arcadeDrive(yInput, xInput);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
