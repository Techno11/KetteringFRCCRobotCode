/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutonDrive extends Command {
  private double seconds, speed;
  private Timer timer;
  public AutonDrive(double seconds, double speed) {
    requires(Robot.driveSubsystem);
    this.seconds = seconds;
    this.speed = speed;
    this.timer = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
    Robot.driveSubsystem.tankDrive(speed, speed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return this.timer.get() >= this.seconds;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
