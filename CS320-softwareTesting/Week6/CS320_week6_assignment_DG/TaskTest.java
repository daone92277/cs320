import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void shouldCreateTaskWithValidId() {
        // Act
        Task task = new Task("1234567890", "Task Name", "Task Description");

        // Assert
        assertEquals("1234567890", task.getId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void shouldThrowExceptionWhenCreatingTaskWithInvalidId() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Task("abcdefghijk", "Task Name", "Task Description"));
    }

    @Test
    public void shouldUpdateTaskName() {
        // Act
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setName("New Task Name");

        // Assert
        assertEquals("1234567890", task.getId());
        assertEquals("New Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void shouldUpdateTaskDescription() {
        // Act
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setDescription("New Task Description");

        // Assert
        assertEquals("1234567890", task.getId());
        assertEquals("Task Name", task.getName());
        assertEquals("New Task Description", task.getDescription());
    }
}
