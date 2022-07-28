// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private VictorSPX rearRight, frontRight, rearLeft, frontLeft;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    // Instantiate Motors
    rearRight = new VictorSPX(Constants.RearRight);
    frontRight = new VictorSPX(Constants.FrontRight);
    rearLeft = new VictorSPX(Constants.RearLeft);
    frontLeft = new VictorSPX(Constants.FrontLeft);

    // Set Reverse
    rearRight.setInverted(true);
    frontRight.setInverted(true);
  }

  public void drive(double forwardSpeed, double turnSpeed) {
    double left = forwardSpeed + turnSpeed;
    double right = forwardSpeed - turnSpeed;

    rearRight.set(ControlMode.PercentOutput, right);
    frontRight.set(ControlMode.PercentOutput, right);
    rearLeft.set(ControlMode.PercentOutput, left);
    frontLeft.set(ControlMode.PercentOutput, left);
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
