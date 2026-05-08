// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.opmode;

import org.wpilib.command3.Scheduler;
import org.wpilib.command3.Trigger;
import org.wpilib.driverstation.DefaultUserControls;
import org.wpilib.driverstation.Gamepad;
import org.wpilib.math.geometry.Pose2d;
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
    
    Scheduler.getDefault().setDefaultCommand(robot.mecanumMechanism, 
      robot.mecanumMechanism.driveCartesianCmd(gamepad1, true)
    );

    Trigger resetFieldCentricTrigger = new Trigger(() -> gamepad1.getDpadUpButton());

    resetFieldCentricTrigger.onTrue(robot.mecanumMechanism.run(co -> {
      robot.mecanumMechanism.setPose(new Pose2d());
    }).named("ResetPoseCmd"));
  }

  @Override
  public void periodic() {
    Scheduler.getDefault().run();
  }
}
