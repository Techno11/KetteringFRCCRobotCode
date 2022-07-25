// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OneMotorSubsystem;

public class IntakeRollerCommand extends CommandBase {

  private OneMotorSubsystem intakeRoller;
  private double speed;

  /** Creates a new IntakeRollerCommand. */
  public IntakeRollerCommand(OneMotorSubsystem subsystem, double speed) {
    this.speed = speed;
    this.intakeRoller = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeRoller.run(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeRoller.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
