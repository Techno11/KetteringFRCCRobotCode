// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OneMotorSubsystem;

public class IntakeLiftCommand extends CommandBase {

  private OneMotorSubsystem intakeLift;
  private XboxController joystick;

  /** Creates a new IntakeLiftCommand. */
  public IntakeLiftCommand(OneMotorSubsystem subsystem, XboxController js) {
    intakeLift = subsystem;
    joystick = js;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeLift.run(joystick.getLeftTriggerAxis() - joystick.getRightTriggerAxis());
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
