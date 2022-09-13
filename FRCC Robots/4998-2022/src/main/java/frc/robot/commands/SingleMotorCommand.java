// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SingleMotorSubsystem;

public class SingleMotorCommand extends CommandBase {

  private SingleMotorSubsystem m_ss;
  private double m_speed;
  /** Creates a new SingleMotorCommand. */
  public SingleMotorCommand(SingleMotorSubsystem ss, double speed) {
    m_ss = ss;
    m_speed = speed;
    addRequirements(ss);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ss.run(m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ss.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
