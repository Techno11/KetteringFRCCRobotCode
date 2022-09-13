// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  private Joystick m_joystick;
  private DriveSubsystem m_subsystem;

  /** Creates a new DriveCommand. */
  public DriveCommand(DriveSubsystem ds, Joystick js) {
    m_joystick = js;
    m_subsystem = ds;
    addRequirements(ds);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.driveMech(-m_joystick.getRawAxis(Constants.JS_X), m_joystick.getRawAxis(Constants.JS_Y), -m_joystick.getRawAxis(Constants.JS_ROT));
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
