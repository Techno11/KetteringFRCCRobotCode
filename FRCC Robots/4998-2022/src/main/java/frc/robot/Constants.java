// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int LEFT_REAR_DRIVE = 1,
                            RIGHT_REAR_DRIVE = 3,
                            LEFT_FRONT_DRIVE = 0,
                            RIGHT_FRONT_DRIVE = 2,

                            MANIP_LIFT = 5,

                            INTAKE = 4,

                            HANG = 6;


    public static final int JS_X = 0,
                            JS_Y = 1,
                            JS_ROT = 2,
                            JS_SLIDER = 3;
}
