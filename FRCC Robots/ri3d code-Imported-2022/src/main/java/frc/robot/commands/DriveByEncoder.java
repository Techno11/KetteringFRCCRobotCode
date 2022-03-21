// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveByEncoder extends CommandBase {
  private DriveSubsystem m_driveSubsystem;
  private double m_forwardPower, m_turnPower;
  private int m_distanceInFeet;

  /** Creates a new DriveTimed. */
  public DriveByEncoder(DriveSubsystem subsystem, double forwardPower, double turnPower, int distanceInFeet) {
    addRequirements(subsystem);
    m_driveSubsystem = subsystem;
    m_forwardPower = forwardPower;
    m_turnPower = turnPower;
    m_distanceInFeet = distanceInFeet;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.resetLeftEncoder();
    m_driveSubsystem.arcadeDrive(m_forwardPower, m_turnPower);
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
    // Turn the encoder ticks into "feet" using the constant
    int feetTraveled = m_driveSubsystem.getLeftEncoderCount() / Constants.ENCODER_COUNTS_PER_FOOT;
    // Calcualte the absoloute value of the distance traveled (basically ignore forward/backwards)
    int absolouteFeetTraveled = Math.abs(feetTraveled);
    // Check if the distance traveled is greater/equal to our desired distance
    return absolouteFeetTraveled >= m_distanceInFeet;
  }
}
