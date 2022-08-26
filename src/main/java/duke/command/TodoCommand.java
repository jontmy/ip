package duke.command;

import duke.internal.Storage;
import duke.internal.Ui;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;

import java.io.IOException;

/**
 * A command to add a to-do task to the task list.
 * Usage: todo <description>
 */
public class TodoCommand extends Command {
    private final String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws IOException {
        Task task = new Todo(description);
        tasks.addTask(task);
        ui.showMessage("I've added this task.")
                .showMessage(task.toString())
                .showTaskListSize(tasks);
        storage.save(tasks);
    }
}
