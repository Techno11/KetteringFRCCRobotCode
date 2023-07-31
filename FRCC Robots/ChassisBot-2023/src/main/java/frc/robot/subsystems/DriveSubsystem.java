// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  public static enum DriveType {
    PWM,
    CANSparkMax
  }

  private PWMVictorSPX pwmRearRight, pwmFrontRight, pwmRearLeft, pwmFrontLeft;
  private CANSparkMax smRearRight, smFrontRight, smRearLeft, smFrontLeft;
  private ShuffleboardTab tab;
  private SendableChooser<DriveType> drivetrain = new SendableChooser<DriveType>();
  private DriveType activeDs = DriveType.PWM;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    initPWM();
    tab = Shuffleboard.getTab("Drivetrain");
    drivetrain.setDefaultOption("PWM", DriveType.PWM);
    drivetrain.addOption("CANSparkMax", DriveType.CANSparkMax);

    tab.add("Chasis Type", drivetrain)
    .withPosition(3, 0)
    .withSize(2, 1);
  }

  public DriveType getDrivetrian() {
    return this.drivetrain.getSelected();
  }

  private void readShuffleboard() {
    DriveType selected = drivetrain.getSelected();
    if (activeDs != selected) {
      if (selected == DriveType.PWM) {
        destroySparkMax();
        initPWM();
      } else {
        destroyPWM();
        initSparkMax();
      }
      activeDs = selected;
    }
  }

  private void initSparkMax() {
    // Instantiate Motors
    smRearRight = new CANSparkMax(Constants.RearRight + 1, MotorType.kBrushed);
    smFrontRight = new CANSparkMax(Constants.FrontRight + 1, MotorType.kBrushed);
    smRearLeft = new CANSparkMax(Constants.RearLeft + 1, MotorType.kBrushed);
    smFrontLeft = new CANSparkMax(Constants.FrontLeft + 1, MotorType.kBrushed);

    // Set Reverse
    smRearRight.setInverted(true);
    smFrontRight.setInverted(true);
  }

  private void initPWM() {
    // Instantiate Motors
    pwmRearRight = new PWMVictorSPX(Constants.RearRight);
    pwmFrontRight = new PWMVictorSPX(Constants.FrontRight);
    pwmRearLeft = new PWMVictorSPX(Constants.RearLeft);
    pwmFrontLeft = new PWMVictorSPX(Constants.FrontLeft);

    // Set Reverse
    pwmRearRight.setInverted(true);
    pwmFrontRight.setInverted(true);
  }

  private void destroyPWM() {
    pwmRearRight.close();
    pwmFrontRight.close();
    pwmRearLeft.close();
    pwmFrontLeft.close();

    pwmRearRight = null;
    pwmFrontRight = null;
    pwmRearLeft = null;
    pwmFrontLeft = null;
  }

  private void destroySparkMax() {
    smRearRight.close();
    smFrontRight.close();
    smRearLeft.close();
    smFrontLeft.close();

    smRearRight = null;
    smFrontRight = null;
    smRearLeft = null;
    smFrontLeft = null;
  }

  public void arcadeDrive(double forwardSpeed, double turnSpeed) {
    double left = -forwardSpeed + turnSpeed;
    double right = -forwardSpeed - turnSpeed;

    if (activeDs == DriveType.PWM) {
      pwmRearRight.set(right);
      pwmFrontRight.set(right);
      pwmRearLeft.set(left);
      pwmFrontLeft.set(left);
    } else {
      smRearRight.set(right);
      smFrontRight.set(right);
      smRearLeft.set(left);
      smFrontLeft.set(left);
    }
  }

  public void tankDrive(double lSpeed, double rSpeed) {
    if (activeDs == DriveType.PWM) {
      pwmRearRight.set(rSpeed);
      pwmFrontRight.set(rSpeed);
      pwmRearLeft.set(lSpeed);
      pwmFrontLeft.set(lSpeed);
    } else {
      smRearRight.set(rSpeed);
      smFrontRight.set(rSpeed);
      smRearLeft.set(lSpeed);
      smFrontLeft.set(lSpeed);
    }
  }

  @Override
  public void periodic() {
    readShuffleboard();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
