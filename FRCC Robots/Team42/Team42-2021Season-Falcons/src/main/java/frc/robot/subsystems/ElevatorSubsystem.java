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
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorCommand;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  private VictorSPX elevator;

  public ElevatorSubsystem() {
    elevator = new VictorSPX(RobotMap.elevator);
  }

  public void elevate(double power) {
    //Read Saftey Switch. If enabled (false), set half power. (default read for DIO port is true)
    power = (Robot.safteySwitch.get()) ? power : power * .5;
    //Set Power
    elevator.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorCommand());
  }
}
