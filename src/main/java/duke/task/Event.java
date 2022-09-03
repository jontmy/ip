package duke.task;

import java.time.LocalDateTime;

/**
 * A task that start at a specific date/time and ends at a specific date/time.
 */
public class Event extends Task {
    private final LocalDateTime dateTime;

    public Event(String description, LocalDateTime dateTime) {
        super(description);
        this.dateTime = dateTime;
    }

    public Event(String description, String dateTime) {
        this(description, LocalDateTime.parse(dateTime, Task.DATE_TIME_FORMATTER));
    }

    public Event(String description, String dateTime, boolean isDone) {
        this(description, dateTime);
        this.isDone = isDone;
    }

    public static Task deserialize(String str) {
        String[] parts = str.split("\\|");
        if (parts.length != 4 || !parts[0].equals("E")) {
            throw new IllegalArgumentException("Invalid event format");
        }
        return new Event(parts[2], parts[3], Boolean.parseBoolean(parts[1]));
    }

    @Override
    public String serialize() {
        return String.format(
                "E|%s|%s|%s",
                isDone,
                description,
                Task.DATE_TIME_FORMATTER.format(dateTime)
        );
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)",
                super.toString(),
                Task.DATE_TIME_FORMATTER.format(dateTime)
        );
    }
}
