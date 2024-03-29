package frc.robot;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.math.util.Units;
import frc.robot.utils.NamedID;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class General {}

    public static final class Auto {
        public static enum Position {
            Nothing,
            Left,
            Middle,
            Right
        }
        public static enum Goal {
            Safe,
            Ambitious,
        }
        public static enum Test {

        }
    }

    public static final class Drivetrain {
        public static final NamedID LEFT_DRIVE_MASTER_ID = new NamedID("Left-Drive-Master-ID", 0);
        public static final NamedID LEFT_DRIVE_ID = new NamedID("Left-Drive-ID", 1);
        public static final NamedID RIGHT_DRIVE_MASTER_ID = new NamedID("Right-Drive-Master-ID", 14);
        public static final NamedID RIGHT_DRIVE_ID = new NamedID("Right-Drive-ID", 15);

        public static final Double LEFT_TICKS_PER_REV = 79675.000000 / Units.inchesToMeters(75); // 18600.0
        public static final Double RIGHT_TICKS_PER_REV = 84660.000000 / Units.inchesToMeters(81); // 9326 19500.0

        public static final Double MAX_VELOCITY = 3.6; // 1 ft 0.3048 * 5
        public static final Double MAX_ACCELERATION = 0.777; // 0.1 * 5
        public static final Double MAX_VOLTS = 100.0;

        public static final Double kTrackwidthMeters = 0.635; // 4.211691140585359 0.635
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);

        public static final Double kS = 0.843; // 0.37
        public static final Double kV = 0.327; // 0.224
        public static final Double kA = 0.014; // 0.0109
        public static final Double kP = 0.000324; // 0.000439
        public static final Double kD = 0.000158; // 0.000183

        public static final DifferentialDriveVoltageConstraint autoVoltageConstraint = new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(
                kS,
                kV,
                kA
            ),
            kDriveKinematics, 10
        );

        public static final TrajectoryConfig config = new TrajectoryConfig(MAX_VELOCITY, MAX_ACCELERATION).setKinematics(kDriveKinematics).addConstraint(autoVoltageConstraint);
    
        public static final double[] HEADING_PID = {0.014, 0.011, 0.0023}; // 0.014 0.011 0.0023 0.014 0.013 0.0033
        public static final double[] FAST_HEADING_PID = {0.2, 0.008, 0.1};

        public static final double TURN_TOLERANCE = 0.2; // 0.01
        public static final double TURN_RATE_TOLERANCE = 10.0;

        public static final double MAX_TURN_RATE = 100.0;
        public static final double MAX_TURN_ACCEL = 300.0;

        public static final double[] DIST_PID = {0.00009, 0.00003, 0.000001}; 

        public static final double DIST_TOLERANCE = 50.0;
        public static final double DIST_RATE_TOLERANCE = 300.0;

        public static final double MAX_DIST_VEL = 10.0;
        public static final double MAX_DIST_ACCEL = 30.0;

        public static final double[] STABILIZATION_PID = {0.3, 0.0, 0.003};
    }

    public static final class Turret {}

    public static final class Shooter {
        public static final NamedID SHOOTER_1_ID = new NamedID("Shooter-1-ID", 2);
        public static final NamedID SHOOTER_2_ID = new NamedID("Shooter-2-ID", 13);
        public static final Double SHOOTER_TICKS_PER_REV = 20000.0;

        public static final Double kP = 0.037; // 0.037
        public static final Double kI = 0.0;
        public static final Double kD = 0.0;
        public static final Double kF = 0.1; // 0.07
    }

    public static final class Intake {
        public static final NamedID INTAKE_ID = new NamedID("Intake-ID", 4);
        public static final NamedID XFACTOR_ID = new NamedID("Xfactor-ID", 1);
    }

    public static final class HorizIndexer {
        public static final NamedID LEFT_INDEXER_ID = new NamedID("Left-Indexer-ID", 5);
        public static final NamedID RIGHT_INDEXER_ID = new NamedID("Right-Indexer-ID", 10);
    }

    public static final class VertIndexer {
        public static final NamedID INDEXER_ID = new NamedID("Indexer-ID", 11);
    }

    public static final class Climber {
        public static final NamedID LEFT_CLIMBER_ID = new NamedID("Left-Climber", 3);
        public static final NamedID RIGHT_CLIMBER_ID = new NamedID("Right-Climber", 12);
    }

    public static final class Playstation {
        
        // Driver Controls
        public static final NamedID USBID = new NamedID("Driver-USB-ID", 0);

        // Axis
        public static final NamedID LeftXAxis = new NamedID("Driver-Left-X-Axis", 0);
        public static final NamedID LeftYAxis = new NamedID("Driver-Left-Y-Axis", 1);
        public static final NamedID RightXAxis = new NamedID("Driver-Right-X-Axis", 2);
        public static final NamedID RightYAxis = new NamedID("Driver-Right-Y-Axis", 5);

        // Trigger
        public static final NamedID LeftTrigger = new NamedID("Driver-Left-Trigger", 3);
        public static final NamedID RightTrigger = new NamedID("Driver-Right-Trigger", 4);

        // Bumper
        public static final NamedID LeftBumper = new NamedID("Driver-Left-Bumper", 5);
        public static final NamedID RightBumper = new NamedID("Driver-Right-Bumper", 6);

        // Buttons
        public static final NamedID SquareButton = new NamedID("Driver-Square-Button", 1);
        public static final NamedID XButton = new NamedID("Driver-X-Button", 2);
        public static final NamedID CircleButton = new NamedID("Driver-Circle-Button", 3);
        public static final NamedID TriangleButton = new NamedID("Driver-Triangle-Button", 4);

        public static final NamedID LeftTriggerButton = new NamedID("Driver-Left-Trigger-Button", 7);
        public static final NamedID RightTriggerButton = new NamedID("Driver-Right-Trigger-Button", 8);

        public static final NamedID LeftButton = new NamedID("Driver-Left-Button", 9);
        public static final NamedID RightButton = new NamedID("Driver-Right-Button", 10);

        public static final NamedID LeftJoystickButton = new NamedID("Driver-Left-Joystick-Button", 11);
        public static final NamedID RightJoystickButton = new NamedID("Driver-Right-Joystick-Button", 12);
        public static final NamedID MiddleButton = new NamedID("Driver-Middle-Joystick-Button", 13);
        public static final NamedID BigButton = new NamedID("Driver-Big-Button", 14);

        // POV Button
        public static final NamedID NorthPOVButton = new NamedID("Driver-North-POV-Button", 0);
        public static final NamedID NorthEastPOVButton = new NamedID("Driver-North-East-POV-Button", 45);
        public static final NamedID EastPOVButton = new NamedID("Driver-East-POV-Button", 90);
        public static final NamedID SouthEastPOVButton = new NamedID("Driver-North-POV-Button", 135);
        public static final NamedID SouthPOVButton = new NamedID("Driver-North-POV-Button", 180);
        public static final NamedID SouthWestPOVButton = new NamedID("Driver-North-POV-Button", 225);
        public static final NamedID WestPOVButton = new NamedID("Driver-North-POV-Button", 270);
        public static final NamedID NorthWestPOVButton = new NamedID("Driver-North-POV-Button", 315);
    }
}
