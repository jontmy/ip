package duke.task;

import java.time.format.DateTimeFormatter;

/**
 * A task has a description and a status tracking whether it is done or not.
 * Tasks cannot be instantiated directly - they should be inherited by a subclass.
 */
public abstract class Task {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(
            "d/M/y H:mm");
    protected final String description;
    protected boolean isDone;

    /**
     * Returns a new Task object.
     *
     * @param description the description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a new Task object.
     *
     * @param description the description of the task
     * @param isDone      whether the task is done
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns a task object from a serialized string.
     * Subclasses should implement this method as well to deserialize the task
     * and added below.
     *
     * @param str the serialized task
     * @return the deserialized task object
     * @since Level-7
     */
    public static Task deserialize(String str) {
        switch (str.charAt(0)) {
        case 'T':
            return Todo.deserialize(str);
        case 'E':
            return Event.deserialize(str);
        case 'D':
            return Deadline.deserialize(str);
        default:
            throw new IllegalArgumentException("Invalid task format");
        }
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of this task, meant for writing to a file.
     * We will assume that no part of the task (e.g. description) contains
     * the delimiter used to separate the different parts of the task during serialization.
     *
     * @return the serialized task
     * @since Level-7
     */
    public abstract String serialize();

    /**
     * Returns a checkmark `✓` if the task is done, an empty string otherwise.
     *
     * @return the status icon
     */
    private String getStatusIcon() {
        return (isDone ? "✓" : " ");
    }

    /**
     * Marks this task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks this task as undone.
     */
    public void markAsUndone() {
        isDone = false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }
}
