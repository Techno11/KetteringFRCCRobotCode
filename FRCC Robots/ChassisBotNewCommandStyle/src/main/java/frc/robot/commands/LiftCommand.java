// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.LiftSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

/** An example command that uses an example subsystem. */
public class LiftCommand extends CommandBase {
  private final LiftSubsystem localLiftSubsystem;
  private final Joystick localJoystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LiftCommand(LiftSubsystem subsystem, Joystick js) {
    localLiftSubsystem = subsystem;
    localJoystick = js;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    localLiftSubsystem.runLift(localJoystick.getRawAxis(3) - localJoystick.getRawAxis(2));
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
