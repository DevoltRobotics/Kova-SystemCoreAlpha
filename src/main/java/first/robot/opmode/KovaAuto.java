// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.opmode;

import org.wpilib.command3.Scheduler;
import org.wpilib.math.geometry.Pose2d;
import org.wpilib.math.geometry.Rotation2d;
import org.wpilib.opmode.Autonomous;
import org.wpilib.opmode.PeriodicOpMode;
import first.robot.Robot;

@Autonomous(name = "Kova Auto", group = "Group 1")
public class KovaAuto extends PeriodicOpMode {
  private final Robot robot;

  /** The Robot instance is passed into the opmode via the constructor. */
  public KovaAuto(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void start() {
    robot.mecanumMechanism.setPose(new Pose2d());

    Scheduler.getDefault().schedule(
      robot.mecanumMechanism.driveToPointCmd(new Pose2d(0.5, 0, Rotation2d.fromDegrees(0)), 1)
      .andThen(robot.mecanumMechanism.driveToPointCmd(new Pose2d(0, 0, Rotation2d.fromDegrees(180)), 1))
      .withAutomaticName()
    );
  }

  /*
   * This method runs periodically, using the same period as the Robot instance.
   *
   * Additional periodic methods may be configured with addPeriodic(),
   * which can have periods that differ from the main Robot instance.
   */
  @Override
  public void periodic() {
    Scheduler.getDefault().run();
  }
}
