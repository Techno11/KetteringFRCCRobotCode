package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Drivetrain.Align;
import frc.robot.commands.Drivetrain.ArcadeDrive;
import frc.robot.commands.Drivetrain.TankDrive;
import frc.robot.commands.Macros.Index;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HorizIndexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.VertIndexer;

public class RightAuton extends SequentialCommandGroup {

    /**
     * This Auton mode was left in as an example of some of the functions avaliable from this robot
     */

    public RightAuton(Drivetrain drivetrain, Intake intake, HorizIndexer horizIndexer, VertIndexer vertIndexer, Shooter shooter) {
        super(
            // new TankDrive(drivetrain, -0.25, -0.25).withTimeout(1.5),
            new ParallelCommandGroup(
                new Shoot(shooter, 22000.0),
                new SequentialCommandGroup(
                    new Align(drivetrain).withTimeout(3.0),
                    new Index(horizIndexer, vertIndexer, intake)
                )
            )
        );

    }
}