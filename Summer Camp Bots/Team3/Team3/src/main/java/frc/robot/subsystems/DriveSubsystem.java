/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  
  
  private VictorSPX leftDrive, rightDrive;

  public DriveSubsystem() {
    leftDrive = new VictorSPX(RobotMap.leftDrive);
    rightDrive = new VictorSPX(RobotMap.rightDrive);
  }

  public void drive(double leftPower, double rightPower){
    leftPower = leftPower * .75;
    rightPower = rightPower * .75;
    leftDrive.set(ControlMode.PercentOutput, leftPower);
    rightDrive.set(ControlMode.PercentOutput, -rightPower);
  }

  public void arcadeDrive(double forwardPower, double turnPower) {
    forwardPower = forwardPower * .65;
    turnPower = turnPower * .65;
    leftDrive.set(ControlMode.PercentOutput, forwardPower - turnPower);
    rightDrive.set(ControlMode.PercentOutput, forwardPower + turnPower);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}
