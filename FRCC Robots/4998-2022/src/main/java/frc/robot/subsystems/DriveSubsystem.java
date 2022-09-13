// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private PWMVictorSPX leftRear, leftFront, rightRear, rightFront;


  public DriveSubsystem() {
    leftRear = new PWMVictorSPX(Constants.LEFT_REAR_DRIVE);
    leftFront = new PWMVictorSPX(Constants.LEFT_FRONT_DRIVE);
    rightRear = new PWMVictorSPX(Constants.RIGHT_REAR_DRIVE);
    rightFront = new PWMVictorSPX(Constants.RIGHT_FRONT_DRIVE);

    leftFront.setInverted(true);
    leftRear.setInverted(true);
  }
  
  public void driveMech(double x, double y, double rx) {
    leftFront.set(y + x + rx);
    leftRear.set(y - x + rx);
    rightFront.set(y - x - rx);
    rightRear.set(y + x - rx);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
