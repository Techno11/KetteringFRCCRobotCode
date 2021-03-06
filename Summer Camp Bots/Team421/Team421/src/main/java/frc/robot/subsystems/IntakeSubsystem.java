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
import frc.robot.commands.IntakeCommand;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {
  
  private TalonSRX intake;
  
  public IntakeSubsystem() {
    intake = new TalonSRX(RobotMap.intake);
  }

  public void intake(double power) {
    intake.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeCommand());
  }
}
