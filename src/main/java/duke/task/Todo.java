package duke.task;

/**
 * A task without any date or time attached to it.
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Returns a Todo deserialized from a string.
     *
     * @param str the string to deserialize
     * @return the deserialized Todo
     */
    public static Task deserialize(String str) {
        String[] parts = str.split("\\|");
        if (parts.length != 3 || !parts[0].equals("T")) {
            throw new IllegalArgumentException("Invalid todo format");
        }
        return new Todo(parts[2], Boolean.parseBoolean(parts[1]));
    }

    @Override
    public String serialize() {
        return String.format("T|%s|%s", isDone, description);
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
