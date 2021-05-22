/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.*;

public class AutoShoot extends CommandBase {
  public final Intake in;
  /**
   * Creates a new AutoShoot.
   */
  public AutoShoot(Intake subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    in = subsystem;
    addRequirements(in);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.intake.count = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.intake.runIntakeSystem(0, 0, false, false, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Robot.intake.count > 5000){
      return true;
    }
    else return false;
  }
}
