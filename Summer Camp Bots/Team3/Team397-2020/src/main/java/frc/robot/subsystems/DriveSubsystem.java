/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  
  
  private VictorSP leftDrive, rightDrive;

  public DriveSubsystem() {
    leftDrive = new VictorSP(RobotMap.leftDrive);
    rightDrive = new VictorSP(RobotMap.rightDrive);
  }

  public void drive(double leftPower, double rightPower){
    leftDrive.set(leftPower);
    rightDrive.set(-rightPower);
  }

  public void arcadeDrive(double forwardPower, double turnPower) {
    leftDrive.set(forwardPower - turnPower);
    rightDrive.set(forwardPower + turnPower);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}
