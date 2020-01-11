/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.*;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveManual extends CommandBase {
  /**
   * Creates a new DriveManual.
   */
  private Subsystem curvatureDrive;

  public DriveManual(Subsystem driveTrain) {
    curvatureDrive = driveTrain;
    addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = RobotContainer.Joystick().getRawAxis(3) - RobotContainer.Joystick().getRawAxis(2);
    double rotation = -RobotContainer.Joystick().getRawAxis(0);
    boolean quickTurn = speed > -0.2 && speed < 0.2;
    if (speed > -0.2 && speed < 0.2){
      speed = 0;
    }
    if (rotation > -0.2 && rotation < 0.2){
      rotation = 0;
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
