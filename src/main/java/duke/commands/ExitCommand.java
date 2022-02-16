package duke.commands;

import java.io.IOException;

import duke.data.TaskList;
import duke.ui.Ui;
import duke.storage.Storage;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command{
    
    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n\t\t"
            + "Example: " + COMMAND_WORD;

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        storage.store(tasks.toList());
        return ui.showExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
