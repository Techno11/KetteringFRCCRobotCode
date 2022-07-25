// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GenericCommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeIndexShoot extends ParallelCommandGroup {
  /** Creates a new IntakeIndexNoTop. */
  public IntakeIndexShoot(IntakeSubsystem intakeSubsystem, IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem, double intakeSpeed, double indexSpeed, double shooterSpeed, boolean lowerIndexOnly) {
    addCommands(
      new IntakeCommand(intakeSubsystem, intakeSpeed),
      new IndexerCommand(indexerSubsystem, indexSpeed, lowerIndexOnly),
      new ShooterCommand(shooterSubsystem, shooterSpeed)
    );
  }
}
