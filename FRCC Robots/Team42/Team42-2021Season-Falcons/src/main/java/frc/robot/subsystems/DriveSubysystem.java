/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.music.Orchestra;

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
  private VictorSPX hDrive; 
  private TalonFX lDriveRear, lDriveFront, rDriveRear, rDriveFront;

  public DriveSubysystem() {
    hDrive = new VictorSPX(RobotMap.hDrive);
    lDriveRear = new TalonFX(RobotMap.lDriveRear);
    lDriveFront= new TalonFX(RobotMap.lDriveFront);
    rDriveRear = new TalonFX(RobotMap.rDriveRear);
    rDriveFront = new TalonFX(RobotMap.rDriveFront);

    //Set Follower and invert
    lDriveRear.setInverted(InvertType.InvertMotorOutput);
    lDriveFront.setInverted(InvertType.InvertMotorOutput);

    lDriveFront.follow(lDriveRear);
    rDriveFront.follow(rDriveRear);
  }

  public void drive(double forwardPower, double hPower, double turnPower) {
    //Read the saftey switch. If switch is on (false) half the power (Default Reading for DIO port is true)
    double y = (Robot.safteySwitch.get()) ? forwardPower : forwardPower * .3;
    double x = (Robot.safteySwitch.get()) ? hPower : hPower * .3;
    double rot = (Robot.safteySwitch.get()) ? turnPower : turnPower * .3;
    //Calculate Motors
    lDriveRear.set(ControlMode.PercentOutput, y - rot);
    rDriveRear.set(ControlMode.PercentOutput, y + rot);
    hDrive.set(ControlMode.PercentOutput, x);
    
  }

  public void playFile(String name) {
    ArrayList<TalonFX> motors = new ArrayList<TalonFX>();
    motors.add(lDriveFront);
    motors.add(lDriveRear);
    motors.add(rDriveFront);
    motors.add(rDriveRear);
    /* Create the orchestra with the TalonFX instruments */
    Orchestra orchestra = new Orchestra(motors);

    orchestra.loadMusic(name);
    orchestra.play();
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }
}
