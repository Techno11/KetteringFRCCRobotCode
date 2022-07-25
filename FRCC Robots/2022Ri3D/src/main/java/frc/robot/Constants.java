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

    //////////// CTRE Devices \\\\\\\\\\\\
    // TalonFX
    public static final int ShooterL = 5;
    public static final int ShooterR = 6;

    // Talon SRXs
    public static final int IndexerMid = 10; // Bottom, Front-to-back (755)
    public static final int IndexerSide = 9; // Bottom, Slide-to-right indexer (755) 
    public static final int IndexerTop = 12; // Top-most, midship indexer (bag motor)
    public static final int IndexerUp = 11; // Rear-most indexer (755)

    // Victor SPX
    public static final int Intake = 8;

    //////////// REV Devices \\\\\\\\\\\\
    
    // Drive Motors (Spark Max)
    public static final int LeftRear_D1 = 1;
    public static final int LeftFront_D2 = 2;
    public static final int RightRear_D3 = 3;
    public static final int RightFront_D4 = 4;

    // Climber Motor (Spark Max)x
    public static final int Climber = 7;

    public static final int PneumaticsHub = 1;

    public static final int PowerHub = 1;
    

}
