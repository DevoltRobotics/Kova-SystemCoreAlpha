// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.opmode;

import org.wpilib.command3.Scheduler;
import org.wpilib.driverstation.DefaultUserControls;
import org.wpilib.driverstation.Gamepad;
import org.wpilib.opmode.PeriodicOpMode;
import org.wpilib.opmode.Teleop;
import first.robot.Robot;

@Teleop
public class KovaTeleop extends PeriodicOpMode {
  private final Robot robot;

  private final DefaultUserControls controls;

  /** The Robot instance is passed into the opmode via the constructor. */
  public KovaTeleop(Robot robot, DefaultUserControls controls) {
    this.robot = robot;
    this.controls = controls;
  }

  @Override
  public void start() {
    Gamepad gamepad1 = controls.getGamepad(0);
    Scheduler.getDefault().schedule(robot.mecanumSubsystem.driveCmd(gamepad1));
  }

  @Override
  public void periodic() {
    Scheduler.getDefault().run();
  }
}
