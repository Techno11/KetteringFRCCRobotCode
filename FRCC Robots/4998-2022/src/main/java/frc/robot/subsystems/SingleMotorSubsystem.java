// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SingleMotorSubsystem extends SubsystemBase {

  private PWMVictorSPX m_motor;

  /** Creates a new SingleMotorSubsystem. */
  public SingleMotorSubsystem(int channel) {
    m_motor = new PWMVictorSPX(channel);
  }

  public void run(double speed) {
    m_motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
