// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  // CUSTOM: Global access to passed in drive subsystem, initilized in constructor
  private DriveSubsystem localDriveSubsystem;
  private Joystick localJoystick;

  /** Creates a new DriveCommand. */
  // CUSTOM: Require DriveSubsystem and joystick as parameters
  public DriveCommand(DriveSubsystem ds, Joystick js) {
    this.localDriveSubsystem = ds;
    this.localJoystick = js;
    // Use addRequirements() here to declare subsystem dependencies.
    // CUSTOM: Add subsystem requirements
    addRequirements(ds);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPower = localJoystick.getRawAxis(1);
    double rightPower = localJoystick.getRawAxis(5);
    this.localDriveSubsystem.drive(leftPower, rightPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
