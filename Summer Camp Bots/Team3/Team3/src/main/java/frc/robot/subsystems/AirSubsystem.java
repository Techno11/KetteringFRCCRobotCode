/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class AirSubsystem extends Subsystem {
  
  private Compressor compressor;
  private Solenoid rampLift1, rampLift2, collector1, collector2;

  public AirSubsystem() {
    compressor = new Compressor(0);
    rampLift1 = new Solenoid(RobotMap.rampLift1);
    rampLift2 = new Solenoid(RobotMap.rampLift2);
    collector1 = new Solenoid(RobotMap.collector1);
    collector2 = new Solenoid(RobotMap.collector2);

    compressor.enabled();
  }

  public void rampLift(boolean active){
    rampLift1.set(active);
    rampLift2.set(!active);
  }

  public void collector(boolean active) {
    collector1.set(active);
    collector2.set(!active);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
