/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  public Joystick stick = new Joystick(0);
  Button aButton = new JoystickButton(stick, 1);
  Button bButton = new JoystickButton(stick, 2);
  Button xButton = new JoystickButton(stick, 3);
  Button yButton = new JoystickButton(stick, 4);
  Button lBumper = new JoystickButton(stick, 5);
  Button rBumper = new JoystickButton(stick, 6);
  Button backButton = new JoystickButton(stick, 7);
  Button startButton = new JoystickButton(stick, 8);
  Button lJoystickButton = new JoystickButton(stick, 9);
  Button rJoystickButton = new JoystickButton(stick, 10);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  public OI() {
    aButton.whenPressed(new ArmCommand(1));
    aButton.whenReleased(new ArmCommand(0));
    bButton.whenPressed(new ArmCommand(-1));
    bButton.whenReleased(new ArmCommand(0));

    lBumper.whenPressed(new ServoCommand(1));
    rBumper.whenPressed(new ServoCommand(0));
  }
  

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
