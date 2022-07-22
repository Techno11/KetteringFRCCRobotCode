// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonGroups;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutonCommands.DriveTimed;
import frc.robot.commands.AutonCommands.IntakeTimed;
import frc.robot.commands.AutonCommands.LiftTimed;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ManipSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoBallTimed extends SequentialCommandGroup {
  /** Creates a new DropAndMoveBack. */
  public TwoBallTimed(Drivetrain ds, ManipSubsystem ms, IntakeSubsystem is, ADXRS450_Gyro gyro) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // First, run intake in reverse to score pre-load ball
      new IntakeTimed(is, 1, .8),
      // Back away from wall
      new DriveTimed(ds, .6, 0, .5),
      // Turn 180
      new DriveTimed(ds, 0, .6, 1.3),
      // Lower Intake
      new LiftTimed(ms, -.4, .5),
      // Drive Forward and Suck
      new DriveNSuck(ds, is, ms, gyro, -.3, 0, -1, -.2, 2),
      // Raise Intake
      new LiftTimed(ms, .4, .6),
      // Turn 180
      new DriveTimed(ds, 0, -.6, 1.21),
      // Drive Towards Wall
      new DriveTimed(ds, -.6, 0, 1.5),
      // Spit out ball
      new DriveNSuck(ds, is, ms, gyro, -.2, 0, 1, 0, 1),
      // Back away from wall
      new DriveTimed(ds, .6, 0, 1.5)
    );
  }
}
