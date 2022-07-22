// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AuxSubsystem;

public class AuxCommandTriggers extends CommandBase {
  private AuxSubsystem m_aux;
  private Joystick m_js;
  
  /** Creates a new AuxCommandTrigger. */
  public AuxCommandTriggers(AuxSubsystem aux, Joystick js) {
    m_aux = aux;
    m_js = js;
    addRequirements(aux);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double power = m_js.getRawAxis(Constants.RIGHT_TRIGGER) - m_js.getRawAxis(Constants.LEFT_TRIGGER);
    m_aux.run(power);
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
