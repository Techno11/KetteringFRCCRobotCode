/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  
  private CANSparkMax rft, rfb, rrt, rrb, lft, lfb, lrt, lrb;

  public DriveSubsystem() {
    rft = new CANSparkMax(RobotMap.R_F_T, MotorType.kBrushless);
    rfb = new CANSparkMax(RobotMap.R_F_B, MotorType.kBrushless);

    rrt = new CANSparkMax(RobotMap.R_R_T, MotorType.kBrushless);
    rrb = new CANSparkMax(RobotMap.R_R_B, MotorType.kBrushless);

    lft = new CANSparkMax(RobotMap.L_F_T, MotorType.kBrushless);
    lfb = new CANSparkMax(RobotMap.L_F_B, MotorType.kBrushless);

    lrt = new CANSparkMax(RobotMap.L_R_T, MotorType.kBrushless);
    lrb = new CANSparkMax(RobotMap.L_R_B, MotorType.kBrushless);
  }

  public void tankDrive(double leftPower, double rightPower){
    rightPower = -rightPower;
    rft.set(rightPower);
    rfb.set(rightPower);

    rrt.set(rightPower);
    rrb.set(rightPower);

    lft.set(leftPower);
    lfb.set(leftPower);

    lrt.set(leftPower);
    lrb.set(leftPower);
  }
  
  /**
   * Cartesian drive method that specifies speeds in terms of the field longitudinal and lateral directions, using the drive's 
   * angle sensor to automatically determine the robot's orientation relative to the field. 
   * <p> 
   * Using this method, the robot will move away from the drivers when the joystick is pushed forwards, and towards the 
   * drivers when it is pulled towards them - regardless of what direction the robot is facing. 
   * 
   * @param x The speed that the robot should drive in the X direction. [-1.0..1.0] 
   * @param y The speed that the robot should drive in the Y direction. This input is inverted to match the forward == -1.0 
   *        that joysticks produce. [-1.0..1.0] 
   * @param rotation The rate of rotation for the robot that is completely independent of the translation. [-1.0..1.0] 
   */ 
  public void mechDrive(double x, double y, double rotation) { 
      double xIn = dzify(x); 
      double yIn = dzify(y); 
      rotation = dzify(rotation);
      // Negate y for the joystick. 
      yIn = -yIn; 
      // Compensate for gyro angle. 
      double r = Math.hypot(xIn, yIn);
      double robotAngle = Math.atan2(yIn, xIn) - Math.PI / 4;
      double rightX = rotation;
      final double v1 = r * Math.cos(robotAngle) + rightX; // Left Front
      final double v2 = r * Math.sin(robotAngle) - rightX; // Right Front
      final double v3 = r * Math.sin(robotAngle) + rightX; // Left Rear
      final double v4 = r * Math.cos(robotAngle) - rightX; // Right Rear

      lft.set(v1); 
      lfb.set(v1); 
      lrt.set(v3); 
      lrb.set(v3); 
      rft.set(v2); 
      rfb.set(v2); 
      rrt.set(v4); 
      rrb.set(v4); 
  } 
  /**
   * Disable all drive motors
   */

public void disable() {
  lft.set(0);
  lfb.set(0);
  lrt.set(0);
  lrb.set(0);
  rft.set(0);
  rfb.set(0);
  rrt.set(0);
  rrb.set(0);
}

/**
 * Enables all drive motors
 */
public void enable() {
  lft.set(0);
  lfb.set(0);
  rft.set(0);
  rfb.set(0);
  lrt.set(0);
  lrb.set(0);
  rrt.set(0);
  rrb.set(0);
}

/**
 * 	Deadzonifies a double to the set deadzone in RobotMap
 * @param A double between -1 and 1
 * @return A double that is now been deadzoned
 */
private double dzify(double value) {
  double deadzone = RobotMap.deadzone;
  if(value > deadzone || value < -deadzone) {
    return value;
  }
  return 0.0;
}


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopDriveCommand());
  }
}
