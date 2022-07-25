// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  private TalonFX shooterL, shooterR;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shooterL = new TalonFX(Constants.ShooterL);
    shooterR = new TalonFX(Constants.ShooterR);

    shooterR.follow(shooterL);
    shooterR.setInverted(InvertType.OpposeMaster);
  }

  public void runPercent(double speed) {
    // Motor operates reverse of what makes logical sense (positive is backwards) so we reverse it here
    shooterL.set(ControlMode.PercentOutput, -speed);
  }

  /**
   * Run Shooter @ given velocity
   * @param velocity Position change per 100ms
   */
  public void runVelocity(int velocity) {
    // Check if 0, if 0, use percent control, as velocity control is wack @ 0
    if(velocity == 0) {
      shooterL.set(ControlMode.PercentOutput, 0);
    } else {
      shooterL.set(ControlMode.Velocity, velocity);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
