// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutonCommandGroup. */
  public AutonCommandGroup(DriveSubsystem ds) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new DriveAuton(ds, .3, .3, 2), // drive forward at .3 power for 2 seconds
                new DriveAuton(ds, -.3, -.3, 2),// drive backwards at .3 power for 2 seconds
                new DriveAuton(ds, .3, -.3, 1), // rotate at .3 power for 1 seconds
                new DriveAuton(ds, -.3, .3, 1)  // rotate at -.3 power for 1 seconds
                );
  }
}
