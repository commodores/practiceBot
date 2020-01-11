/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.IFollower;

import frc.robot.RobotContainer;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  //drivetrain decives
  private TalonSRX leftMasterSrx = new TalonSRX(1);
  private TalonSRX leftSlaveSrx = new TalonSRX(2);
  private TalonSRX leftSlaveSrx2 = new TalonSRX(3);

  private TalonSRX rightMasterSrx = new TalonSRX(4);
  private TalonSRX rightSlaveSrx = new TalonSRX(5);
  private TalonSRX rightSlaveSrx2 = new TalonSRX(6);
 
  public DifferentialDrive drive = new DifferentialDrive(leftMasterSrx, rightMasterSrx);

  public DriveTrain() {
    setDefaultCommand(new DriveManual(this));
   
    rightSlaveSrx.follow(rightMasterSrx);
    rightSlaveSrx2.follow(rightMasterSrx);
    leftSlaveSrx.follow(leftMasterSrx);
    leftSlaveSrx2.follow(leftMasterSrx);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveCurvature(double speed, double rotation, boolean quickTurn){
    m_drive.set(ControlMode.PercentOutput, speed , rotation, quickTurn );
    m_drive.curvatureDrive(ControlMode.PercentOutput, speed , rotation, quickTurn);
  }
}
