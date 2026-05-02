package first.robot.subsystem;

import java.util.function.DoubleSupplier;

import org.wpilib.command3.Command;
import org.wpilib.command3.Mechanism;
import org.wpilib.drive.MecanumDrive;
import org.wpilib.driverstation.Gamepad;
import org.wpilib.hardware.expansionhub.ExpansionHubMotor;

public class MecanumSubsystem extends Mechanism {

    ExpansionHubMotor frontLeft, rearLeft, frontRight, rearRight;

    MecanumDrive drive = new MecanumDrive(frontLeft::setThrottle, rearLeft::setThrottle, frontRight::setThrottle, rearRight::setThrottle);

    public MecanumSubsystem(ExpansionHubMotor frontLeft, ExpansionHubMotor rearLeft, ExpansionHubMotor frontRight, ExpansionHubMotor rearRight) {
        this.frontLeft = frontLeft;
        this.rearLeft = rearLeft;
        this.frontRight = frontRight;
        this.rearRight = rearRight;
    }

    public void drive(double x, double y, double rotation) {
        drive.driveCartesian(x, y, rotation);
    }

    public Command driveCmd(DoubleSupplier x, DoubleSupplier y, DoubleSupplier rotation) {
        return run(co -> {
            while(true) {
                drive.driveCartesian(x.getAsDouble(), y.getAsDouble(), rotation.getAsDouble());
                co.yield();
            }
        }).named("MecanumDriveCmd");
    }

    public Command driveCmd(Gamepad gamepad) {
        return driveCmd(gamepad::getLeftX, () -> -gamepad.getLeftY(), gamepad::getRightX);
    }
    
}