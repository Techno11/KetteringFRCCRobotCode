// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonGroups;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutonCommands.DriveGyroTimed;
import frc.robot.commands.AutonCommands.DriveTimed;
import frc.robot.commands.AutonCommands.IntakeTimed;
import frc.robot.commands.AutonCommands.LiftTimed;
import frc.robot.commands.AutonCommands.TurnGyro;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ManipSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoBallGyro extends SequentialCommandGroup {
  /** Creates a new DropAndMoveBack. */
  public TwoBallGyro(Drivetrain ds, ManipSubsystem ms, IntakeSubsystem is, ADXRS450_Gyro gyro) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // First, run intake in reverse to score pre-load ball
      new IntakeTimed(is, 1, .8),
      // Back away from wall
      new DriveGyroTimed(.6, .5, ds, gyro),
      // Turn 180
      new TurnGyro(.5, 155, ds, gyro),
      // Lower Intake
      new LiftTimed(ms, -.4, .5),
      // Drive Forward and Suck
      new DriveNSuck(ds, is, ms, gyro, -.3, 0, -1, -.2, 1.5),
      // Raise Intake
      new LiftTimed(ms, .5, .6),
      // Turn 180
      new TurnGyro( -.5, 165, ds, gyro),
      // Drive Towards Wall
      new DriveGyroTimed(-.6, 1.5, ds, gyro),
      // Drive Towards Wall, but slower
      new DriveGyroTimed(-.3, .5, ds, gyro),
      // Spit out ball
      new DriveNSuck(ds, is, ms, gyro, -.2, 0, 1, 0, 1),
      // Back away from wall
      new DriveGyroTimed(.6, 1.5, ds, gyro)
    );
  }
}
