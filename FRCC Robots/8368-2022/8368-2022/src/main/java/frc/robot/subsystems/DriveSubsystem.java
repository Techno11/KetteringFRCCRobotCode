// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private CANSparkMax left_rear_drive, left_front_drive, right_rear_drive, right_front_drive;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    left_rear_drive = new CANSparkMax(Constants.LEFT_REAR_DRIVE, MotorType.kBrushed);
    left_front_drive = new CANSparkMax(Constants.LEFT_FRONT_DRIVE, MotorType.kBrushed);
    right_rear_drive = new CANSparkMax(Constants.RIGHT_REAR_DRIVE, MotorType.kBrushed);
    right_front_drive = new CANSparkMax(Constants.RIGHT_FRONT_DRIVE, MotorType.kBrushed);
  }

  public void arcadeDrive(double forwardPower, double turnPower) {
    double leftPower = forwardPower - turnPower;
    double rightPower = forwardPower + turnPower;

    left_rear_drive.set(leftPower);
    left_front_drive.set(leftPower);
    right_rear_drive.set(-rightPower);
    right_front_drive.set(-rightPower);
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
