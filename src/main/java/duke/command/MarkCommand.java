package duke.command;

import java.io.IOException;

import duke.internal.MessageBuilder;
import duke.internal.Parser;
import duke.internal.Storage;
import duke.task.Task;
import duke.task.TaskList;

/**
 * A command to mark a task in the task list as done.
 * Usage: mark [0]
 * [0]: index of the task to mark as done
 * Note that the index starts at 1.
 */
public class MarkCommand extends Command {
    public final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, MessageBuilder messageBuilder,
                        Parser parser) throws IOException {
        Task task = tasks.getTask(index);
        task.markAsDone();
        messageBuilder.addLine("I've marked your task as done.").addLine(task.toString());
        storage.saveTasks(tasks);
    }
}
