// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveTimed extends CommandBase {
  private DriveSubsystem m_driveSubsystem;
  private double m_forwardPower, m_turnPower, m_duration;
  private Timer m_timer;

  /** Creates a new DriveTimed. */
  public DriveTimed(DriveSubsystem subsystem, double forwardPower, double turnPower, double duration) {
    addRequirements(subsystem);
    m_driveSubsystem = subsystem;
    m_forwardPower = forwardPower;
    m_turnPower = turnPower;
    m_duration = duration;
    m_timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.arcadeDrive(m_forwardPower, m_turnPower);
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_timer.get() >= m_duration;
  }
}
