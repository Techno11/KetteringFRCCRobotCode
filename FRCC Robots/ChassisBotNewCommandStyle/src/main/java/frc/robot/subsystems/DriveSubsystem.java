// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  // CUSTOM: Define Motor Controllers
  public VictorSPX lDrive, rDrive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    // CUSTOM: Instantiate Motor Controllers
    lDrive = new VictorSPX(Constants.K_LEFT_DRIVE_PORT);
    rDrive = new VictorSPX(Constants.K_RIGHT_DRIVE_PORT);
  }

  // HINT: Hold [ctrl] key and hover over things to see their references/documentations (if they exist)
  // CUSTOM: Drive Motor Accessor Classes
  public void drive(double leftPower, double rightPower){
      lDrive.set(ControlMode.PercentOutput, -leftPower);
      rDrive.set(ControlMode.PercentOutput, rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
