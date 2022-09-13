// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SingleMotorSubsystem;

public class SingleMotorAnalogCommand extends CommandBase {

  private SingleMotorSubsystem m_ss;
  private int m_axis;
  private Joystick m_js;
  private boolean m_invert;
  private double m_multiplier = 1;
  /** Creates a new SingleMotorCommand. */
  public SingleMotorAnalogCommand(SingleMotorSubsystem ss, Joystick js, int axis, boolean invert, double multiplier) {
    m_ss = ss;
    m_js = js;
    m_axis = axis;
    m_invert = invert;
    m_multiplier = multiplier;
    addRequirements(ss);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ss.run(m_multiplier * (m_invert ? -1 : 1) * m_js.getRawAxis(m_axis));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
