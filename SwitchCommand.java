package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

public class SwitchCommand extends Command {
    private Command comm1;
    private Command comm2;

    private boolean state;

    public SwitchCommand(Command comm1, Command comm2) {
        this.comm1 = comm1;
        this.comm2 = comm2;

        state = true;
    }

    @Override
    public void initialize() {
        // Flipping the boolean
        state = !state;

        // Initializing the selected command.
        if (state) {
            comm1.initialize();
        } else {
            comm2.initialize();
        }
    }

    @Override
    public void execute() {
        // Executing the selected command.
        if (state) {
            comm1.execute();
        } else {
            comm2.execute();
        }
    }

    @Override
    public boolean isFinished() {
        // Checking if the selected command is finished.
        if (state) {
            return comm1.isFinished();
        } else {
            return comm2.isFinished();
        }
    }

    @Override
    public void end(boolean interrupted) {
        // Running the end function
        if (state) {
            comm1.end(interrupted);
        } else {
            comm2.end(interrupted);
        }
    }
}
