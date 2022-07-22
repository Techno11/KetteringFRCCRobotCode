// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonCommands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveGyroTimed extends CommandBase {
  private final Drivetrain m_drive;
  private final ADXRS450_Gyro m_gyro;
  private final double m_speed, m_duration;
  private final Timer m_timer;

  // Degrees that we start at
  private double startDegrees = 0;

  // Max deviation from "straight"
  private double maxDelta = 3;

  // Speed to correct at
  // Gyro is reverse of Romi, so correction speed is negative
  private double correctionSpeed = -.3;

  /**
   * Creates a new DriveGyroTime. This command will drive the robot in a straight
   * line
   */
  public DriveGyroTimed(double speed, double time, Drivetrain subsystem, ADXRS450_Gyro gyro) {
    m_drive = subsystem;
    m_gyro = gyro;
    m_speed = speed;
    m_duration = time;
    m_timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Reset and start timer
    m_timer.reset();
    m_timer.start();

    // Reset Gyro
    m_gyro.reset();

    // Read start Gyro Position
    startDegrees = Math.abs(m_gyro.getRotation2d().getDegrees());

    // Start Driving
    m_drive.arcadeDrive(m_speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {    
    // Calculate current delta
    double currentDelta = m_gyro.getRotation2d().getDegrees() - startDegrees;

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
