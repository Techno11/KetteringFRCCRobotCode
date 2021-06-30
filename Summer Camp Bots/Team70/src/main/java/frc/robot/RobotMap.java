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
  //Deadzone
  public static double deadzone = 0.2;

  // Spark Brushless Motors
  public static int R_F_T = 1; 
  public static int R_F_B = 10; //Original was 0
   
  public static int R_R_T = 3; 
  public static int R_R_B = 4; 

  public static int L_F_T = 8; 
  public static int L_F_B = 17; //Original was 7

  public static int L_R_T = 6; 
  public static int L_R_B = 5; //Original was 5

  public static int hab_pegs = 11;

  public static int elevator = 12;
}
