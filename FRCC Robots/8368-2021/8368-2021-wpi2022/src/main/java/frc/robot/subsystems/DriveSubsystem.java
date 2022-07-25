/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  // Motors
  private VictorSPX lDrive1, lDrive2, rDrive1, rDrive2;

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    // Instantiate Motors
    lDrive1 = new VictorSPX(Constants.DriveConstants.kLeftMotor1Port);
    lDrive2 = new VictorSPX(Constants.DriveConstants.kLeftMotor2Port);
    rDrive1 = new VictorSPX(Constants.DriveConstants.kRightMotor1Port);
    rDrive2 = new VictorSPX(Constants.DriveConstants.kRightMotor2Port);

    // Left Drive 2 follow master
    lDrive2.follow(lDrive1);

    // Invert Right Side, setup follower
    rDrive1.setInverted(InvertType.InvertMotorOutput);
    rDrive2.follow(rDrive1);
    rDrive2.setInverted(InvertType.FollowMaster);
  }

  /**
   * Stops the robot.
   */
  public void stop() {
    lDrive1.set(ControlMode.PercentOutput, 0);
    rDrive1.set(ControlMode.PercentOutput, 0);
  }

    /**
   * Drives the robot using arcade controls.
   */
  public void arcadeDrive(double fwd, double rot) {
    double lPower = -fwd + rot;
    double rPower = -fwd - rot;

    // "Clip" Ranges
    if(lPower > 1) lPower = 1;
    if(lPower < -1) lPower = -1;
    if(rPower > 1) rPower = 1;
    if(rPower < -1) rPower = -1;

    // Always run at 50% power to prevent serious injury
    lPower *= .75;
    rPower *= .75;

    lDrive1.set(ControlMode.PercentOutput, lPower);
    rDrive1.set(ControlMode.PercentOutput, rPower);
  }
}
