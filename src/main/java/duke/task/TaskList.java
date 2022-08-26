package duke.task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import fp.Streamable;

/**
 * A TaskList stores a list of tasks.
 */
public class TaskList implements Streamable<Task> {
    private final List<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(List<Task> list) {
        this.list = list;
    }

    @Override
    public Stream<Task> stream() {
        return list.stream();
    }

    /**
     * Adds a task to the list.
     *
     * @param task a string value of the task to add
     */
    public void addTask(Task task) {
        list.add(task);
    }

    /**
     * Deletes the task at the given index from the list.
     *
     * @param index the index of the task to delete
     */
    public void deleteTask(int index) {
        list.remove(index);
    }

    /**
     * Returns the task at the given index.
     *
     * @param index the index of the task to return
     * @return the task at the given index
     */
    public Task getTask(int index) {
        return list.get(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return the number of tasks in the list
     */
    public int size() {
        return list.size();
    }

    /**
     * Enumerates the tasks stored in this TaskList.
     *
     * @return the enumerated list of tasks
     */
    @Override
    public String toString() {
        return IntStream.range(0, list.size())
                .mapToObj(i -> String.format("%d. %s\n", i + 1, list.get(i)))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString()
                .trim();
    }
}
