package duke.command;

import java.io.IOException;

import duke.internal.Storage;
import duke.internal.Ui;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;

/**
 * A command to add an event task to the task list.
 * Usage: event [0] /at [1]
 * [0]: description
 * [1]: date
 */
public class EventCommand extends Command {
    private final String description;
    private final String datetime;

    public EventCommand(String description, String datetime) {
        this.description = description;
        this.datetime = datetime;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws IOException {
        Task task = new Event(description, datetime);
        tasks.addTask(task);
        ui.showMessage("I've added this event.")
                .showMessage(task.toString())
                .showTaskListSize(tasks);
        storage.saveTasks(tasks);
    }
}
