/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {

  private TalonSRX rDrive1, rDrive2, lDrive1, lDrive2;

  public DriveSubsystem(){
    //Init Motor Controllers
    rDrive1 = new TalonSRX(RobotMap.rDrive1);
    rDrive2 = new TalonSRX(RobotMap.rDrive2);
    lDrive1 = new TalonSRX(RobotMap.lDrive1);
    lDrive2 = new TalonSRX(RobotMap.lDrive2);

    //Set left inverted
    lDrive1.setInverted(true);
    lDrive2.setInverted(true);

    //Set Slave Motor Controllers
    rDrive2.follow(rDrive1);
    lDrive2.follow(lDrive1);
  }

  public void tankDrive(double leftPower, double rightPower) {
    lDrive1.set(ControlMode.PercentOutput, leftPower);
    rDrive1.set(ControlMode.PercentOutput, rightPower);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}

