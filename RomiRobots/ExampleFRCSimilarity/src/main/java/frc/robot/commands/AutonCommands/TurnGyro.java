// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonCommands;

import frc.robot.sensors.RomiGyro;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnGyro extends CommandBase {
  private final Drivetrain m_drive;
  private final double m_degrees;
  private final double m_speed;
  private final RomiGyro m_gyro;

  private double startDegrees = 0;

  /**
   * Creates a new TurnGyro. This command will turn your robot for a desired rotation (in degrees) and rotational speed. 
   */
  public TurnGyro(double speed, double degrees, Drivetrain drive, RomiGyro gyro) {
    m_degrees = Math.abs(degrees);
    m_speed = speed;
    m_drive = drive;
    m_gyro = gyro;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Read start Gyro Position
    startDegrees = Math.abs(m_gyro.getAngleZ());
    // Set motors to start
    m_drive.arcadeDrive(0, m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Do nothing
    m_drive.arcadeDrive(0, m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_gyro.getAngleZ()) - startDegrees > m_degrees;
  }
}
