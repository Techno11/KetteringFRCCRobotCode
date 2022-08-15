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
    // grabber = 2
    // shooter botton = 3
    // shooter top = 1
    // intake = 4
    public static final int rr_drive = 7; // Victor SP (sim top)
    public static final int rf_drive = 8; // Victor SP (sim bott)

    public static final int lr_drive = 5; // Victor SP (sim top)
    public static final int lf_drive = 6; // Victor SP (sim bott)

    public static final int winch = 9; // Victor SP

    public static final int shooter_r = 1; // Victor SP (top)
    public static final int shooter_l = 3; // Victor SP (bott)

    public static final int intake = 4; // Victor SP

    public static final int grabber = 2; // Talon
}
