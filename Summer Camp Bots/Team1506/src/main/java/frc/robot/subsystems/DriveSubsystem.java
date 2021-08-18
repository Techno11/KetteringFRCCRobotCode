/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private TalonFX rfDrive, rrDrive, lfDrive, lrDrive;

  public DriveSubsystem() {
    rfDrive = new TalonFX(Constants.K_RIGHT_DRIVE_FRONT);
    rrDrive = new TalonFX(Constants.K_RIGHT_DRIVE_REAR);
    lfDrive = new TalonFX(Constants.K_LEFT_DRIVE_FRONT);
    lrDrive = new TalonFX(Constants.K_LEFT_DRIVE_REAR);
  }

  public void arcadeDrive(double turnPower, double forwardPower) {
    turnPower = turnPower * .6;
    forwardPower = forwardPower * .6;
    //forwardPower = -forwardPower;
    double leftPwr = forwardPower + turnPower;
    double rightPwr = forwardPower - turnPower;
    rfDrive.set(ControlMode.PercentOutput, rightPwr);
    rrDrive.set(ControlMode.PercentOutput, rightPwr);
    lfDrive.set(ControlMode.PercentOutput, leftPwr);
    lrDrive.set(ControlMode.PercentOutput, leftPwr);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void setDefaultCommand(Command defaultCommand) {
    super.setDefaultCommand(defaultCommand);
  }
}
