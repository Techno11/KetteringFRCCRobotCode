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
import frc.robot.commands.GateCommand;

/**
 * Add your docs here.
 */
public class GateSubsystem extends Subsystem {
  private VictorSPX gate;

  public GateSubsystem() {
    gate = new VictorSPX(RobotMap.gate);
  }

  public void run(double pwr) {
    gate.set(ControlMode.PercentOutput, pwr);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GateCommand());
  }
}
