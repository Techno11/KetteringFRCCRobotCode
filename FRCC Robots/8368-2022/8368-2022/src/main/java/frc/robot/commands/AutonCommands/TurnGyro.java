// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutonCommands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurnGyro extends CommandBase {
  private final Drivetrain m_subsystem;
  private final ADXRS450_Gyro gyro;
  private final double turnPower, degrees;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurnGyro(double turnPower, double degrees, Drivetrain subsystem, ADXRS450_Gyro gyro) {
    m_subsystem = subsystem;
    this.gyro = gyro;
    this.degrees = degrees;
    this.turnPower = turnPower;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.gyro.reset();
    m_subsystem.arcadeDrive(0, this.turnPower);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(this.gyro.getRotation2d().getDegrees()) >= Math.abs(degrees);
  }
}
