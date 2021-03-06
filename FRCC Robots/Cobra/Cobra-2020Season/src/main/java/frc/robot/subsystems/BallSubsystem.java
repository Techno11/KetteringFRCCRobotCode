/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BallSubsystem extends Subsystem {

  private VictorSP intake, output;

  public BallSubsystem() {
    intake = new VictorSP(RobotMap.intakeMotor);
    output = new VictorSP(RobotMap.outputMotor);
  }

  public void runOutput(double power) {
    output.set(power);
  }

  public void runIntake(double power) {
    intake.set(power);
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
