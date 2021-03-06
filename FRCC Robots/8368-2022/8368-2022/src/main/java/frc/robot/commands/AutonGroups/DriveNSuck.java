// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonGroups;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.AutonCommands.DriveGyroTimed;
import frc.robot.commands.AutonCommands.IntakeTimed;
import frc.robot.commands.AutonCommands.LiftTimed;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ManipSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveNSuck extends ParallelCommandGroup {
  /** Creates a new DriveNSuck. */
  public DriveNSuck(Drivetrain ds, IntakeSubsystem is, ManipSubsystem ms, ADXRS450_Gyro gyro, double drivePower, double turnPower, double intakePower, double liftPower, double time) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // Drive
      new DriveGyroTimed(drivePower, time, ds, gyro), 
      // Intake
      new IntakeTimed(is, intakePower, time),
      // Put a small amount of downward pressure to keep the arm down
      new LiftTimed(ms, liftPower, time)
      );
  }
}
