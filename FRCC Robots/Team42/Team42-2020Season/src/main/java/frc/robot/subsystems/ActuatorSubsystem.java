/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ActuatorSubsystem extends Subsystem {
  private VictorSPX actuator;
  private AnalogPotentiometer pot;

  public ActuatorSubsystem() {
    actuator = new VictorSPX(RobotMap.actuator);
    pot = new AnalogPotentiometer(0);
    actuator.setNeutralMode(NeutralMode.Brake);
  }

  public void actuate(double power) {
    //Read Saftey Switch. If enabled (false), set half power. (default read for DIO port is true)
    power = (Robot.safteySwitch.get()) ? power : power * .5;
    //Set Power
    if(getPot() > .8371 && power < 0) {
      //power = 0;
    }
    if(getPot() < .5271 && power > 0) {
      //power = 0;
    }
    actuator.set(ControlMode.PercentOutput, power);
  }

  public void forceActuate(double power){
    actuator.set(ControlMode.PercentOutput, power);
  }

  public double getPot() {
    return pot.get();
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
