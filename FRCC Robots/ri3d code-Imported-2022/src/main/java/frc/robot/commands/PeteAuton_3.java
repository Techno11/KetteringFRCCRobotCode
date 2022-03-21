// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PeteAuton_3 extends SequentialCommandGroup {
  /** Creates a new PeteAuton_3. */
  public PeteAuton_3(DriveSubsystem driveSubsytem, AHRS gyro) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
   
    // for(int i = 1; i < 4; i++){
    //   addCommands(
    //     new DriveByEncoder(driveSubsytem, 0.5, 0, i),
    //     new DriveByEncoder(driveSubsytem, -0.5, 0, i)
    //   );
    // }

    addCommands(
      new TurnByGyro(driveSubsytem, gyro, .5, 90)
    );
  }
}
