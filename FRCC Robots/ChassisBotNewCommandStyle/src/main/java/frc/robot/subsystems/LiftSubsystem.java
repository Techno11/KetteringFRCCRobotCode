// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {
  private VictorSPX lift;

  /** Creates a new ExampleSubsystem. */
  public LiftSubsystem() {
    lift = new VictorSPX(Constants.K_LIFT_PORT);
  }

  public void runLift(double power) {
    lift.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
