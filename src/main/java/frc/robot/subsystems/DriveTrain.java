/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.IFollower;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.RobotContainer;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  // drivetrain decives
  private WPI_TalonSRX leftMasterSrx = new WPI_TalonSRX(1);
  private WPI_TalonSRX leftSlaveSrx = new WPI_TalonSRX(2);
  private WPI_TalonSRX leftSlaveSrx2 = new WPI_TalonSRX(3);

  private WPI_TalonSRX rightMasterSrx = new WPI_TalonSRX(4);
  private WPI_TalonSRX rightSlaveSrx = new WPI_TalonSRX(5);
  private WPI_TalonSRX rightSlaveSrx2 = new WPI_TalonSRX(6);
  
  private final DifferentialDrive m_Drive;

 

  public DriveTrain() {
    setDefaultCommand(new DriveManual(this));

    rightSlaveSrx.follow(rightMasterSrx);
    rightSlaveSrx2.follow(rightMasterSrx);
    leftSlaveSrx.follow(leftMasterSrx);
    leftSlaveSrx2.follow(leftMasterSrx);

    rightSlaveSrx.setInverted(false);
    rightSlaveSrx2.setInverted(false);
    leftSlaveSrx.setInverted(false);
    leftSlaveSrx2.setInverted(false);

    rightSlaveSrx.setNeutralMode(NeutralMode.Brake);
    rightSlaveSrx2.setNeutralMode(NeutralMode.Brake);
    leftSlaveSrx.setNeutralMode(NeutralMode.Brake);
    leftSlaveSrx2.setNeutralMode(NeutralMode.Brake);

    m_Drive = new DifferentialDrive(leftMasterSrx, rightMasterSrx);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveCurvature(double speed, double rotation, boolean quickTurn) {
    driveCurvature(speed, rotation, quickTurn);
    
  }
}
