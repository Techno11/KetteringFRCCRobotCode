// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexerSubsystem;

public class IndexerCommand extends CommandBase {

  private IndexerSubsystem m_subsystem;
  private double m_speed;
  private boolean m_lowerOnly;

  /** Creates a new IndexerCommand. */
  public IndexerCommand(IndexerSubsystem subsystem, double speed,  boolean lowerOnly) {
    m_subsystem = subsystem;
    m_speed = speed;
    m_lowerOnly = lowerOnly;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(m_lowerOnly) {
      m_subsystem.runIntakeIndex(m_speed);
    } else {
      m_subsystem.runIntakeIndex(m_speed);
      m_subsystem.runUpIndex(m_speed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {    
    m_subsystem.runIntakeIndex(0);
    m_subsystem.runUpIndex(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
