// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OneMotorSubsystem extends SubsystemBase {

  private VictorSPX motor;

  /** Creates a new IntakeLiftSubsystem. */
  public OneMotorSubsystem(int motorChannel) {
    motor = new VictorSPX(motorChannel);
  }

  public void run(double speed) {
    motor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
