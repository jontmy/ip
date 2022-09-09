package duke.command;

import java.io.IOException;

import duke.internal.Parser;
import duke.internal.Storage;
import duke.internal.Ui;
import duke.task.TaskList;

/**
 * A command to list all the tasks in the task list.
 * Usage: list
 */
public class ListCommand extends Command {
    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui, Parser parser) throws IOException {
        if (tasks.size() == 0) {
            ui.showMessage("You do not have any tasks at the moment.");
        } else {
            ui.showMessage("Here are your tasks!").showMessage(tasks.toString());
        }
    }
}
