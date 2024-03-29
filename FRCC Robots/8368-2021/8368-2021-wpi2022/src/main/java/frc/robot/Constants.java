/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    public static final int kLeftMotor1Port = 12;
    public static final int kLeftMotor2Port = 16;
    public static final int kRightMotor1Port = 10;
    public static final int kRightMotor2Port = 11;
  }

  public static final class IntakeConstants {
    public static final int kIntakeLiftMotor = 13;
    public static final int kIntakeRollerMotor = 15;
  }

  public static final class ClimbConstants {
    public static final int kClimbMotor = 14;
  }

  public static final class AutoConstants {
    public static final double kAutoDriveTime = 2.0;
    public static final double kAutoDriveSpeed = 0.5;
    public static final double kAutoDriveDistanceInches = 60;
    public static final double kAutoBackupDistanceInches = 20;

  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }
}
