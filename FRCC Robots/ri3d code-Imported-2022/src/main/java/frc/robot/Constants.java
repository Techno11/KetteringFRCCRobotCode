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
    public static final int rr_drive = 4; // Victor SPX
    public static final int rf_drive = 2; // Talon

    public static final int lr_drive = 3; // Victor SPX
    public static final int lf_drive = 1; // Talon

    public static final int nothing = 5; // Victor SPX

    public static final int shooter_r = 7; // Victor SPX
    public static final int shooter_l = 6; // Victor SPX

    public static final int intake = 8; // Victor SPX

    public static final int climber = 9; // Talon

    public static final int ENCODER_COUNTS_PER_FOOT = 24784;
}
