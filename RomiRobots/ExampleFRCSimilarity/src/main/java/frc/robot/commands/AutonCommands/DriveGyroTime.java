// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonCommands;

import frc.robot.sensors.RomiGyro;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveGyroTime extends CommandBase {
  private final Drivetrain m_drive;
  private final double m_duration;
  private final double m_speed;
  private final RomiGyro m_gyro;
  private final Timer m_timer;

  // Degrees that we start at
  private double startDegrees = 0;

  // Max deviation from "straight"
  private double maxDelta = 3;

  // Speed to correct at
  private double correctionSpeed = .3;

  /**
   * Creates a new DriveGyroTime. This command will drive the robot in a straight line
   */
  public DriveGyroTime(double speed, double time, Drivetrain drive, RomiGyro gyro) {
    m_duration = time;
    m_speed = speed;
    m_drive = drive;
    m_gyro = gyro;
    m_timer = new Timer();
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Reset and start timer
    m_timer.reset();
    m_timer.start();

    // Read start Gyro Position
    startDegrees = Math.abs(m_gyro.getAngleZ());
    
    // Set motors to start
    m_drive.arcadeDrive(0, m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Calculate current delta
    double currentDelta = Math.abs(m_gyro.getAngleZ()) - startDegrees;

    // If current delta is greater than maxDelta, correct by turning negative
    if (currentDelta > maxDelta) {
      m_drive.arcadeDrive(m_speed, -correctionSpeed);
    } else if (currentDelta < -maxDelta) { // If current delta is less than -maxDelta, correct by turning positive
      m_drive.arcadeDrive(m_speed, correctionSpeed);
    } else { // We're safe, within delta range
      m_drive.arcadeDrive(m_speed, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_timer.get() >= m_duration;
  }
}
