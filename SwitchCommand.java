package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

public class SwitchCommand extends Command {
    private Command comm1;
    private Command comm2;

    private boolean state;

    /**
     * Creates a new SwitchCommand.
     * <p>
     * Takes two commands as parameters and switches between the two each time the command is run.
     *
     * @param comm1 The first Command to run.
     * @param comm2 The second Command to run.
     */
    public SwitchCommand(Command comm1, Command comm2) {
        this(comm1, comm2, true);
    }

    /**
     * Creates a new SwitchCommand.
     * <p>
     * Takes two commands as parameters and switches between the two each time the command is run.
     *
     * @param comm1 The first Command to run.
     * @param comm2 The second Command to run.
     * @param comm1First Whether or not the second Command will run first.
     */
    public SwitchCommand(Command comm1, Command comm2, boolean comm1First) {
        this.comm1 = comm1;
        this.comm2 = comm2;
        this.state = !comm1First;
    }

    @Override
    /** This function runs once each time the Command is schedules. */
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
    /**
     * This function is called once every "tick" while the Command is scheduled.
     * <p>
     * The default tick time is 0.02 seconds.
     */
    public void execute() {
        // Executing the selected command.
        if (state) {
            comm1.execute();
        } else {
            comm2.execute();
        }
    }

    @Override
    /**
     * Runs at the same time as the execute function and determines if the command is finished.
     * 
     * @return Whether or not the Command has finished running.
     */
    public boolean isFinished() {
        // Checking if the selected command is finished.
        if (state) {
            return comm1.isFinished();
        } else {
            return comm2.isFinished();
        }
    }

    @Override
    /**
     * Runs on the final tick that the Command is scheduled.
     * 
     * @param interrupted Whether or not the Command was interrupted by another process.
     */
    public void end(boolean interrupted) {
        // Running the end function
        if (state) {
            comm1.end(interrupted);
        } else {
            comm2.end(interrupted);
        }
    }
}
