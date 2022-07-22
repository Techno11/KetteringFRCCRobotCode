// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutonCommands.DriveGyroTime;
import frc.robot.commands.AutonCommands.TurnGyro;
import frc.robot.sensors.RomiGyro;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoSecondSquare extends SequentialCommandGroup {
  /** Creates a new TwoSecondSquare. */

  double forwardSpeed = .5; // -1 to 1
  double forwardTime = 2;
  double turnSpeed = .4; // -1 to 1
  double turnDegrees = 90;

  public TwoSecondSquare(Drivetrain m_drivetrain, RomiGyro m_gyro) {
    addCommands(
      // Leg 1
      new DriveGyroTime(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro),
      // Leg 2
      new DriveGyroTime(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro),
      // Leg 3
      new DriveGyroTime(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro),
      // Leg 4
      new DriveGyroTime(forwardSpeed, forwardTime, m_drivetrain, m_gyro),
      new TurnGyro(turnSpeed, turnDegrees, m_drivetrain, m_gyro)
    );
  }
}
