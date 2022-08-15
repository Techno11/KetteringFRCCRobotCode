// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Constants.AvalDriveModes;
import frc.robot.subsystems.DriveSubsystem;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {

  private final DriveSubsystem m_subsystem;
  private final Joystick m_js;

  private SendableChooser<Constants.AvalDriveModes> drivetrainType = new SendableChooser<Constants.AvalDriveModes>();
  private NetworkTableEntry reverseDrivetrain, maxDriveSpeed;
  private ShuffleboardTab tab;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DriveSubsystem subsystem, Joystick js) {
    m_subsystem = subsystem;
    m_js = js;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);

    tab = Shuffleboard.getTab("Drivetrain");

    drivetrainType.setDefaultOption(AvalDriveModes.Arcade.label, AvalDriveModes.Arcade);
    drivetrainType.addOption(AvalDriveModes.ArcadeLeft.label, AvalDriveModes.ArcadeLeft);
    drivetrainType.addOption(AvalDriveModes.ArcadeRight.label, AvalDriveModes.ArcadeRight);
    drivetrainType.addOption(AvalDriveModes.Tank.label, AvalDriveModes.Tank);

    tab.add("Drive Mode", drivetrainType)
        .withPosition(0, 0)
        .withSize(2, 1);

    reverseDrivetrain = tab.add("Reverse Drivetrain", false)
        .withPosition(0, 2)
        .withSize(2, 1)
        .withWidget(BuiltInWidgets.kToggleSwitch)
        .getEntry();

    maxDriveSpeed = tab.add("Max Speed", 1)
        .withWidget(BuiltInWidgets.kNumberSlider)
        .withProperties(Map.of("min", 0, "max", 1))
        .withPosition(0, 1)
        .withSize(2, 1)
        .getEntry();
  }

  public void setInverted(boolean inverted) {
    reverseDrivetrain.setBoolean(inverted);
  }

  public void swapInverted() {
    reverseDrivetrain.setBoolean(!reverseDrivetrain.getBoolean(true));
  }

  public void setDriveMode(Constants.AvalDriveModes drive) {
    drivetrainType.setDefaultOption(drive.label, drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Read from shuffleboard
    Constants.AvalDriveModes dMode = drivetrainType.getSelected();
    boolean doReverse = reverseDrivetrain.getBoolean(false);
    double maxSpeed = maxDriveSpeed.getDouble(1);

    if(dMode != Constants.AvalDriveModes.Tank) {
      int xStick = (dMode == Constants.AvalDriveModes.Arcade) ? Constants.RIGHT_X : 
        (dMode ==  Constants.AvalDriveModes.ArcadeLeft) ? Constants.LEFT_X : Constants.RIGHT_X;
      int yStick = (dMode == Constants.AvalDriveModes.Arcade) ? Constants.LEFT_Y : 
        (dMode == Constants.AvalDriveModes.ArcadeLeft) ? Constants.LEFT_Y : Constants.RIGHT_Y;

      double xVal = m_js.getRawAxis(xStick) * maxSpeed;
      double yVal = m_js.getRawAxis(yStick) * maxSpeed;

      if (!doReverse) {
        yVal = -yVal;
      }

      m_subsystem.arcadeDrive(yVal * .75, xVal * .75);
    } else {
      double lStick = m_js.getRawAxis(Constants.LEFT_Y) * maxSpeed;
      double rStick = m_js.getRawAxis(Constants.RIGHT_Y) * maxSpeed;

      if(doReverse) {
        m_subsystem.tankDrive(lStick * -.75, rStick * -.75);
      } else {
        m_subsystem.tankDrive(rStick * .75, lStick * .75);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
