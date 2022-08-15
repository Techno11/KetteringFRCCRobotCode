// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.AvalButtons;
import frc.robot.subsystems.AuxSubsystem;

public class AuxCommand extends CommandBase {
  private AuxSubsystem m_aux;
  private Joystick m_js;
  private String m_tabName;
  private ShuffleboardTab tab;

  private NetworkTableEntry m_invertM0, m_maxM0;
  private SendableChooser<Constants.AvalButtons> m_buttonsM0;

  private boolean currM0Invert = false;

  /** Creates a new AuxCommand. */
  public AuxCommand(AuxSubsystem aux, Joystick js, String tabName) {
    m_aux = aux;
    m_js = js;
    m_tabName = tabName;
    addRequirements(aux);

    tab = Shuffleboard.getTab(m_tabName);

    m_invertM0 = tab.add("Invert", currM0Invert)
        .withWidget(BuiltInWidgets.kToggleSwitch)
        .withPosition(0, 2)
        .getEntry();

    m_maxM0 = tab.add("Max Speed", 1)
        .withWidget(BuiltInWidgets.kNumberSlider)
        .withProperties(Map.of("min", 0, "max", 1))
        .withPosition(0, 1)
        .withSize(2, 1)
        .getEntry();

    m_buttonsM0 = new SendableChooser<Constants.AvalButtons>();

    // Register all button combos
    m_buttonsM0.setDefaultOption(AvalButtons.A_Y.label, AvalButtons.A_Y);
    m_buttonsM0.addOption(AvalButtons.Triggers.label, AvalButtons.Triggers);
    m_buttonsM0.addOption(AvalButtons.X_B.label, AvalButtons.X_B);
    m_buttonsM0.addOption(AvalButtons.Back_Start.label, AvalButtons.Back_Start);
    m_buttonsM0.addOption(AvalButtons.Bumpers.label, AvalButtons.Bumpers);

    tab.add("Buttons", m_buttonsM0)
        .withPosition(0, 0)
        .withSize(2, 1);
  }

  public void setButtons(AvalButtons buttonGroup) {
    m_buttonsM0.setDefaultOption("A/Y", buttonGroup);
  }

  public void setInverted(boolean inverted) {
     m_invertM0.setBoolean(inverted);
  }

  public void swapInverted() {
    m_invertM0.setBoolean(!m_invertM0.getBoolean(true));
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    AvalButtons selButM0 = m_buttonsM0.getSelected();    
    currM0Invert = m_invertM0.getBoolean(currM0Invert);
    double maxM0 = m_maxM0.getDouble(1);

    m_aux.run0(calcSpeed(currM0Invert, maxM0, selButM0));
  }

  public double calcSpeed(boolean invert, double max, AvalButtons button) {

    // A/Y = 0
    if (button != AvalButtons.Triggers) {
      // Calculate what button to look for
      int forwardButton = (button == AvalButtons.A_Y) ? Constants.JS_A
          : (button == AvalButtons.X_B) ? Constants.JS_X : (button == AvalButtons.Back_Start) ? Constants.JS_BACK : Constants.JS_LB;
      int reverseButton = (button == AvalButtons.A_Y) ? Constants.JS_Y
          : (button == AvalButtons.X_B) ? Constants.JS_B : (button == AvalButtons.Back_Start) ? Constants.JS_START : Constants.JS_RB;

      // If forward button is pressed
      if (m_js.getRawButton(forwardButton)) {
        return (invert ? -1 : 1) * max;
      } else if (m_js.getRawButton(reverseButton)) {
        return (invert ? 1 : -1) * max;
      } else {
        return 0;
      }
    } else { // Triggers = 1
      return (m_js.getRawAxis(Constants.LEFT_TRIGGER) - m_js.getRawAxis(Constants.RIGHT_TRIGGER)) * max
          * (invert ? -1 : 1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_aux.run0(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
