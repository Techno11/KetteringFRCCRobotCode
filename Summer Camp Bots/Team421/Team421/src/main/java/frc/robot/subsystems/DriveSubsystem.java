/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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

  private TalonSRX frontRightDrive, frontLeftDrive, rearRightDrive, rearLeftDrive;

  public DriveSubsystem() {
    frontRightDrive = new TalonSRX(RobotMap.frontRightDrive);
    rearRightDrive = new TalonSRX(RobotMap.rearRightDrive);
    frontLeftDrive = new TalonSRX(RobotMap.frontLeftDrive);
    rearLeftDrive = new TalonSRX(RobotMap.rearLeftDrive);

    rearRightDrive.follow(frontRightDrive);
    rearLeftDrive.follow(frontLeftDrive);

    frontLeftDrive.setInverted(true);
    rearLeftDrive.setInverted(true);
  }

  public void drive(double leftPower, double rightPower){
    frontRightDrive.set(ControlMode.PercentOutput, rightPower);
    frontLeftDrive.set(ControlMode.PercentOutput, leftPower);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}
