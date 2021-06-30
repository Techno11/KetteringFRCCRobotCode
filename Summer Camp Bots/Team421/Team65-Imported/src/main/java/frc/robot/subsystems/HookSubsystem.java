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
import frc.robot.commands.HookCommand;

/**
 * Add your docs here.
 */
public class HookSubsystem extends Subsystem {
  private VictorSPX hook;

  public HookSubsystem() {
    hook = new VictorSPX(RobotMap.hook);
  }

  public void run(double pwr) {
    hook.set(ControlMode.PercentOutput, pwr);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new HookCommand());
  }
}
