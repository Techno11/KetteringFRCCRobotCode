// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveTimed extends CommandBase {

  // Step 1. Create our globals
  private double global_timeToDrive, global_forwardPower, global_turnPower;
  private DriveSubsystem global_ds;
  private Timer global_timer;

  /** Creates a new DriveTimed. */
  public DriveTimed(DriveSubsystem ds, double timeToDrive, double forwardPower, double turnPower) {
    // Step 2: Pass local variables to global
    addRequirements(ds);
    global_ds = ds;
    global_timeToDrive = timeToDrive;
    global_forwardPower = forwardPower;
    global_turnPower = turnPower;
    global_timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Step 3. Tell Robot to go
    global_ds.arcadeDrive(global_forwardPower, global_turnPower);
    global_timer.reset();
    global_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    global_timer.stop();
    global_ds.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return global_timer.get() >= global_timeToDrive;
  }
}
