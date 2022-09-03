package duke.command;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import duke.internal.Parser;
import duke.internal.Storage;
import duke.internal.Ui;
import duke.task.Task;
import duke.task.TaskList;

/**
 * Prints the tasks that contain a given search query in its description.
 * Usage: find [0]
 * [0]: search query
 *
 * @since Level-9
 */
public class FindCommand extends Command {
    private final String query;

    public FindCommand(String query) {
        this.query = query;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui, Parser parser) throws IOException {
        List<Task> results = tasks.stream()
                .filter(task -> task.getDescription().contains(query))
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            ui.showMessage("No tasks matched your query.");
            return;
        }
        String repr = new TaskList(results).toString();
        ui.showMessage("Here are the tasks matching your query:").showMessage(repr);
    }
}
