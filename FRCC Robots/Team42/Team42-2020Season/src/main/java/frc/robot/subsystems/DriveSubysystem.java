/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubysystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSPX lDrive, rDrive, hDrive;

  public DriveSubysystem() {
    lDrive = new VictorSPX(RobotMap.lDrive);
    rDrive = new VictorSPX(RobotMap.rDrive);
    hDrive = new VictorSPX(RobotMap.hDrive);

    //Set Follower and invert
    rDrive.setInverted(InvertType.InvertMotorOutput);
  }

  public void drive(double forwardPower, double hPower, double turnPower) {
    //Read the saftey switch. If switch is on (false) half the power (Default Reading for DIO port is true)
    double y = (Robot.safteySwitch.get()) ? forwardPower : forwardPower * .5;
    double x = (Robot.safteySwitch.get()) ? hPower : hPower * .5;
    double rot = (Robot.safteySwitch.get()) ? turnPower : turnPower * .5;
    //Calculate Motors
    lDrive.set(ControlMode.PercentOutput, y + rot);
    rDrive.set(ControlMode.PercentOutput, y - rot);
    hDrive.set(ControlMode.PercentOutput, x);
    
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}
