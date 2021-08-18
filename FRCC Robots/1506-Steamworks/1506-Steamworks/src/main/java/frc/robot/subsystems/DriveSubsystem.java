/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private TalonSRX rf_drive, lf_drive;
  private VictorSPX rr_drive, lr_drive;

  public DriveSubsystem() {
      rf_drive = new TalonSRX(Constants.rf_drive);
      rr_drive = new VictorSPX(Constants.rr_drive);
      lf_drive = new TalonSRX(Constants.lf_drive);
      lr_drive = new VictorSPX(Constants.lr_drive);
  }

  public void arcadeDrive(double turnPower, double forwardPower) {
    //forwardPower = -forwardPower;
    double leftPwr = forwardPower + turnPower;
    double rightPwr = forwardPower - turnPower;
    rf_drive.set(ControlMode.PercentOutput, rightPwr);
    rr_drive.set(ControlMode.PercentOutput, rightPwr);
    lf_drive.set(ControlMode.PercentOutput, leftPwr);
    lr_drive.set(ControlMode.PercentOutput, leftPwr);
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
