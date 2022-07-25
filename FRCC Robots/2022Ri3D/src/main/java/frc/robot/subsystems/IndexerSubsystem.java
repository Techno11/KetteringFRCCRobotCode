// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexerSubsystem extends SubsystemBase {

  private TalonSRX indexLeftRight, indexFrontRear, indexRearUp, indexMidUp;

  /** Creates a new IndexerSubsystem. */
  public IndexerSubsystem() {
    indexLeftRight = new TalonSRX(Constants.IndexerSide);
    indexFrontRear = new TalonSRX(Constants.IndexerMid);
    indexRearUp =  new TalonSRX(Constants.IndexerUp);
    indexMidUp = new TalonSRX(Constants.IndexerTop);

    // Set Followers
    indexLeftRight.follow(indexFrontRear);
    indexMidUp.follow(indexRearUp);

    // Set Inverts
    indexMidUp.setInverted(InvertType.OpposeMaster);
  }

  public void runIntakeIndex(double speed) {
    indexFrontRear.set(ControlMode.PercentOutput, speed);
  }

  public void runUpIndex(double speed) {
    indexRearUp.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
