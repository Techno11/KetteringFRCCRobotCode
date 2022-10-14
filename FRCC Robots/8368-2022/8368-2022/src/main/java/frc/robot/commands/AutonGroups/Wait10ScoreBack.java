// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutonCommands.DriveTimed;
import frc.robot.commands.AutonCommands.IntakeTimed;
import frc.robot.commands.AutonCommands.TimeDelay;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ManipSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Wait10ScoreBack extends SequentialCommandGroup {
  /** Creates a new DropAndMoveBack. */
  public Wait10ScoreBack(Drivetrain ds, ManipSubsystem ms, IntakeSubsystem is) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // Wait 10 Seconds
      new TimeDelay(10),
      // Drop and Move Back
      new DropAndMoveBack(ds, ms, is)
    );
  }
}
