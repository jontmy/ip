package duke.command;

import java.io.IOException;

import duke.internal.Parser;
import duke.internal.Storage;
import duke.internal.Ui;
import duke.task.TaskList;


/**
 * Command to exit the program.
 * Usage: bye
 */
public class ByeCommand extends Command {
    @Override
    public boolean isTerminal() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui, Parser parser) throws IOException {
        storage.saveTasks(tasks);
        ui.showMessage("Bye! Hope to see you again soon!");
    }
}
