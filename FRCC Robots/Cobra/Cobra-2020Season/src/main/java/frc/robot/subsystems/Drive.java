/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDriveCommand;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {

  private VictorSP lDrive, rDrive, rDriveF, lDriveF;

  public Drive() {
    lDrive = new VictorSP(RobotMap.lDrive);
    rDrive = new VictorSP(RobotMap.rDrive);
    rDriveF = new VictorSP(RobotMap.rDriveF);
    lDriveF = new VictorSP(RobotMap.lDriveF);
  }

  public void tankDrive(double lPower, double rPower){
    lDrive.set(lPower);
    lDriveF.set(lPower);
    rDrive.set(-rPower);
    rDriveF.set(-rPower);
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveCommand());
  }
}
