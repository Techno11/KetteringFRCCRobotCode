/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private VictorSP rf_drive, lf_drive, rr_drive, lr_drive;

  public DriveSubsystem() {
      rf_drive = new VictorSP(Constants.rf_drive);
      rr_drive = new VictorSP(Constants.rr_drive);
      lf_drive = new VictorSP(Constants.lf_drive);
      lr_drive = new VictorSP(Constants.lr_drive);
  }

  public void arcadeDrive(double turnPower, double forwardPower) {
    //forwardPower = -forwardPower;
    double leftPwr = forwardPower + turnPower;
    double rightPwr = forwardPower - turnPower;
    rf_drive.set(rightPwr);
    rr_drive.set(rightPwr);
    lf_drive.set(leftPwr);
    lr_drive.set(leftPwr);
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
