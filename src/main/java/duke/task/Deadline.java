package duke.task;

import java.time.LocalDateTime;

/**
 * A task that needs to be done before a specific date/time.
 */
public class Deadline extends Task {
    private final LocalDateTime deadline;

    /**
     * Returns a new Deadline object.
     *
     * @param description the description of the deadline task
     * @param deadline    the deadline of the task
     */
    public Deadline(String description, LocalDateTime deadline) {
        super(description);
        this.deadline = deadline;
    }

    public Deadline(String description, String deadline) {
        this(description, LocalDateTime.parse(deadline, Task.DATE_TIME_FORMATTER));
    }

    /**
     * Returns a new Deadline object.
     *
     * @param description the description of the deadline task
     * @param deadline    the deadline of the task
     * @param isDone      whether the task is done
     */
    public Deadline(String description, String deadline, boolean isDone) {
        this(description, deadline);
        this.isDone = isDone;
    }

    /**
     * Returns a Deadline deserialized from a string.
     *
     * @param str the string to deserialize
     * @return the deserialized Deadline
     */
    public static Task deserialize(String str) {
        String[] parts = str.split("\\|");
        if (parts.length != 4 || !parts[0].equals("D")) {
            throw new IllegalArgumentException("Invalid deadline format");
        }
        return new Deadline(parts[2], parts[3], Boolean.parseBoolean(parts[1]));
    }

    @Override
    public String serialize() {
        return String.format(
                "D|%s|%s|%s",
                isDone,
                description,
                Task.DATE_TIME_FORMATTER.format(deadline)
        );
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)",
                super.toString(),
                Task.DATE_TIME_FORMATTER.format(deadline)
        );
    }
}
