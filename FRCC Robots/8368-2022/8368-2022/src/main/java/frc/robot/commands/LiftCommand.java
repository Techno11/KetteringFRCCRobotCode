// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ManipSubsystem;

public class LiftCommand extends CommandBase {
  private final ManipSubsystem subsystem;
  private final Joystick js;

  /** Creates a new LiftCommand. */
  public LiftCommand(ManipSubsystem subsystem, Joystick js) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subsystem = subsystem;
    this.js = js;

    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.subsystem.runManip(-this.js.getRawAxis(Constants.LEFT_Y) * .3);
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
