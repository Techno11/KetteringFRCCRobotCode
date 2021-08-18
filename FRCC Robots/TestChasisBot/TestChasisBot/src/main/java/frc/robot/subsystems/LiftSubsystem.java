// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftCommand;

/** Add your docs here. */
public class LiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private VictorSPX lift;

  public LiftSubsystem() {
    lift = new VictorSPX(RobotMap.liftMotor);
  }

  public void runLift (double speed) {
    lift.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftCommand());
  }
}
