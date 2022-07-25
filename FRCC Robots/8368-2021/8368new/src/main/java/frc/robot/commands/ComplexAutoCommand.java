/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A complex auto command that drives forward, stop/do something else, and then drives backward.
 */
public class ComplexAutoCommand extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAutoCommand.
   *
   * @param driveSubsystem The drive subsystem this command will run on
   */
  public ComplexAutoCommand(DriveSubsystem driveSubsystem) {
    addCommands(
        // Drive forward up to the front of the cargo ship
        new StartEndCommand(
            // Start driving forward at the start of the command
            () -> driveSubsystem.arcadeDrive(AutoConstants.kAutoDriveSpeed, 0),
            // Stop driving at the end of the command
            () -> driveSubsystem.arcadeDrive(0, 0), driveSubsystem)
            // Set how long command will run
            .withTimeout(AutoConstants.kAutoDriveTime),

        // Reset encoders, just to do something
        new InstantCommand(driveSubsystem::resetEncoders, driveSubsystem),

        // Drive backward the specified distance
        new StartEndCommand(
            () -> driveSubsystem.arcadeDrive(-AutoConstants.kAutoDriveSpeed, 0),
            () -> driveSubsystem.arcadeDrive(0, 0), driveSubsystem)
            .beforeStarting(driveSubsystem::resetEncoders)
            .withTimeout(AutoConstants.kAutoDriveTime));
  }

}
