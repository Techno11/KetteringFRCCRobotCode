// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private CANSparkMax rightRear, rightFront, leftRear, leftFront;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftRear = new CANSparkMax(Constants.LeftRear_D1, MotorType.kBrushless);
    leftFront = new CANSparkMax(Constants.LeftFront_D2, MotorType.kBrushless);
    rightRear = new CANSparkMax(Constants.RightRear_D3, MotorType.kBrushless);
    rightFront = new CANSparkMax(Constants.RightFront_D4, MotorType.kBrushless);

    // Set the master motor to be inverted
    rightRear.setInverted(true);

    // Setup followers
    rightFront.follow(rightRear);
    leftFront.follow(leftRear);
  }

  public void drive(double fwd, double rot) {
    double lPower = fwd + rot;
    double rPower = fwd - rot;

    // "Clip" Ranges
    if(lPower > 1) lPower = 1;
    if(lPower < -1) lPower = -1;
    if(rPower > 1) rPower = 1;
    if(rPower < -1) rPower = -1;

    // Always run at 75% power to prevent serious injury
    lPower *= .75;
    rPower *= .75;

    leftRear.set(lPower);
    rightRear.set(rPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
