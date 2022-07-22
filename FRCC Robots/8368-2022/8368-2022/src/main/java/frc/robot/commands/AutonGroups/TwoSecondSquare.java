// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonGroups;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutonCommands.DriveGyroTimed;
import frc.robot.commands.AutonCommands.TurnGyro;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoSecondSquare extends SequentialCommandGroup {
  /** Creates a new TwoSecondSquare. */

  double forwardSpeed = .3;
  double forwardTime = 2;
  double turnSpeed = .4;
  double turnDegrees = 90;

  public TwoSecondSquare(Drivetrain m_drivetrain, ADXRS450_Gyro m_gyro) {
    addCommands(
      // Leg 1
      new DriveGyroTimed(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro),
      // Leg 2
      new DriveGyroTimed(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro),
      // Leg 3
      new DriveGyroTimed(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro),
      // Leg 4
      new DriveGyroTimed(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro)
    );
  }
}
