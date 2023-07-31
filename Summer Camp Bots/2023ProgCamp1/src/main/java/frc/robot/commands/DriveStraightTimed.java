// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveStraightTimed extends CommandBase {
  
  private DriveSubsystem global_ds;
  private ADXRS450_Gyro global_gyro;
  private double global_speed, global_driveTime;
  private Timer global_timer = new Timer();

  private final double MAX_DEVIATION = 3; // degrees of deciation from "straight" allowed
  private final double CORRECTION_SPEED = .3;


  public DriveStraightTimed(DriveSubsystem driveSubsystem, ADXRS450_Gyro gyro, double driveTime, double speed) {
    addRequirements(driveSubsystem);
    global_ds = driveSubsystem;
    global_gyro = gyro;
    global_driveTime = driveTime;
    global_speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Reset Gyro
    global_gyro.reset();

    // Reset and start Gyro
    global_timer.reset();
    global_timer.start();
    
    // Start Driving
    global_ds.arcadeDrive(global_speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double degrees = global_gyro.getRotation2d().getDegrees();
    if(degrees >= MAX_DEVIATION) { // Gone to far one direction
      global_ds.arcadeDrive(global_speed, CORRECTION_SPEED);
    } else if (degrees <= -MAX_DEVIATION) { // Gone to far the other direction
      global_ds.arcadeDrive(global_speed, -CORRECTION_SPEED);
    } else { // "Straight"
      global_ds.arcadeDrive(global_speed, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    global_ds.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return global_timer.get() >= global_driveTime;
  }
}
