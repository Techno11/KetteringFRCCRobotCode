// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeTimed extends CommandBase {
  private final IntakeSubsystem subsystem;
  private final double power, time;
  private final Timer timer = new Timer();

  /** Creates a new LiftCommand. */
  public IntakeTimed(IntakeSubsystem subsystem, double power, double time) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subsystem = subsystem;
    this.power = power;
    this.time = time;

    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.timer.reset();
    this.subsystem.runIntake(this.power);
    this.timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.subsystem.runIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.timer.get() >= this.time;
  }
}
