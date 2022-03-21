// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TurnByGyro extends CommandBase {
  private DriveSubsystem m_driveSubsystem;
  private double m_turnPower, m_degrees;
  private AHRS m_gyro;
  private double startingDegrees;

  /** Creates a new DriveTimed. */
  public TurnByGyro(DriveSubsystem subsystem, AHRS gyro, double turnPower, double degrees) {
    addRequirements(subsystem);
    m_driveSubsystem = subsystem;
    m_degrees = degrees;
    m_turnPower = turnPower;
    m_gyro = gyro;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startingDegrees = m_gyro.getRotation2d().getDegrees();
    m_driveSubsystem.arcadeDrive(0, m_turnPower);
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
    // Calculate offset distance, based on starting degrees
    double realDegrees = m_gyro.getRotation2d().getDegrees() - this.startingDegrees;
    // Calculate the absoloute value of the distance we turned
    double absolouteDegrees = Math.abs(realDegrees);
    // Check if absoloute degrees is greater than the desired degrees
    return absolouteDegrees >= this.m_degrees;
  }
}
