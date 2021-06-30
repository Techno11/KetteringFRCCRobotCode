/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSP leftDriveMotor;
  private VictorSP rightDriveMotor;

  public DriveSubsystem() {
    leftDriveMotor = new VictorSP(RobotMap.driveMotorL);
    rightDriveMotor = new VictorSP(RobotMap.driveMotorR);
  }

  public void driveRobot(double leftPower, double rightPower) {
    leftDriveMotor.set(leftPower);
    rightDriveMotor.set(-rightPower);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
