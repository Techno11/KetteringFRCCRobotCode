// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveAuton extends CommandBase {
  // CUSTOM: Global access to passed in drive subsystem, initilized in constructor
  private DriveSubsystem localDriveSubsystem;
  private double localLeftPower, localRightPower, localSeconds;
  private Timer timer;

  /** Creates a new DriveCommand. */
  // CUSTOM: Require DriveSubsystem and each side power, as well as time to run for
  public DriveAuton(DriveSubsystem ds, double leftPower, double rightPower, double seconds) {
    // CUSTOM: turn constructor parameters into local globals
    this.localDriveSubsystem = ds;
    localLeftPower = leftPower;
    localRightPower = rightPower;
    localSeconds = seconds;
    timer = new Timer();
    // CUSTOM: Add subsystem requirements
    addRequirements(ds);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Reset Timer
    timer.reset();
    timer.start();
    // Set Drives to Drive
    this.localDriveSubsystem.drive(localLeftPower, localRightPower);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // CUSTOM: Stop Driving
    this.localDriveSubsystem.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.timer.get() >= this.localSeconds;
  }
}
