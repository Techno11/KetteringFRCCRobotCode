/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

  private VictorSPX ballGrabber;
  private Compressor comp;
  private DoubleSolenoid hatchManip, ballManip;

  public IntakeSubsystem() {
    comp = new Compressor();
    ballGrabber = new VictorSPX(Constants.ballGrabber);
    hatchManip = new DoubleSolenoid(Constants.hatch1, Constants.hatch2);
    ballManip = new DoubleSolenoid(Constants.ball1, Constants.ball2);
  }

  public void runIntake(double power) {
    ballGrabber.set(ControlMode.PercentOutput, power);
  }

  public void hatch(boolean open) {
    hatchManip.set(open ? Value.kForward : Value.kReverse);
  }

  public void ball(boolean open) {
    ballManip.set(open ? Value.kForward : Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
