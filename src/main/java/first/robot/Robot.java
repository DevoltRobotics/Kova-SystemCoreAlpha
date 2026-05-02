// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot;

import org.wpilib.driverstation.DefaultUserControls;
import org.wpilib.driverstation.UserControlsInstance;
import org.wpilib.framework.OpModeRobot;
import org.wpilib.hardware.expansionhub.ExpansionHubMotor;

import first.robot.subsystem.MecanumSubsystem;

/**
 * The methods in this class are called automatically as described in the OpModeRobot documentation.
 * OpMode classes anywhere in the package (or sub-packages) where this class is located are
 * automatically registered to display in the Driver Station. If you change the name of this class
 * or the package after creating this project, you must also update the Main.java file in the
 * project.
 */
@UserControlsInstance(DefaultUserControls.class)
public class Robot extends OpModeRobot {

  // HARDWARE

  ExpansionHubMotor frontLeft = new ExpansionHubMotor(0, 0);
  ExpansionHubMotor rearLeft = new ExpansionHubMotor(0, 1);
  ExpansionHubMotor frontRight = new ExpansionHubMotor(0, 2);
  ExpansionHubMotor rearRight = new ExpansionHubMotor(0, 3);

  // SUBSYSTEMS

  public final MecanumSubsystem mecanumSubsystem = new MecanumSubsystem(frontLeft, rearLeft, frontRight, rearRight);


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    frontLeft.setReversed(true);
    rearLeft.setReversed(true);
  }

  /** This function is called exactly once when the DS first connects. */
  @Override
  public void driverStationConnected() {}

  /**
   * This function is called periodically anytime when no opmode is selected, including when the
   * Driver Station is disconnected.
   */
  @Override
  public void nonePeriodic() {}
}
