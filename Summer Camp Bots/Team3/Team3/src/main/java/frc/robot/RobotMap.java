/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Motor Controllers
  public static final int leftDrive = 1;
  public static final int rightDrive = 2;
  public static final int succMotor = 5;

  public static final int shooterL = 4;
  public static final int shooterR = 3;

  //Solenoids
  public static final int rampLift1 = 0;
  public static final int rampLift2 = 1;
  public static final int collector1 = 2;
  public static final int collector2 = 3;
}
