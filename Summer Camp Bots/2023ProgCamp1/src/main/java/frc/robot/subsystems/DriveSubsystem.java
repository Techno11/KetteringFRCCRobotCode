// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  // Step 1: Create Motor Controllers
  private CANSparkMax leftRear, leftFront, rightRear, rightFront;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    // Step 2: Instantiate Motor Controllers
    leftRear = new CANSparkMax(8, MotorType.kBrushed);
    leftFront = new CANSparkMax(7, MotorType.kBrushed);
    rightRear = new CANSparkMax(6, MotorType.kBrushed);
    rightFront = new CANSparkMax(5, MotorType.kBrushed);

    // Step 3. Set Right motors to be inverted
    rightFront.setInverted(true);
    rightRear.setInverted(true);
  }

  // Step 4. Create Arcade Drive Method
  public void arcadeDrive(double forwardPower, double turnPower) {
    double leftPower = forwardPower - turnPower;
    double rightPower = forwardPower + turnPower;

    leftRear.set(leftPower);
    leftFront.set(leftPower);

    rightRear.set(rightPower);
    rightFront.set(rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
