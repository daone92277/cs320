import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService taskService = new TaskService();

    @Test
    public void shouldAddTaskWithUniqueID() {
        // Act
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);

        // Assert
        assertTrue(taskService.getTasks().containsKey("1234567890"));
        assertEquals(task, taskService.getTasks().get("1234567890"));
    }

    @Test
    public void shouldThrowExceptionWhenAddingTaskWithExistingID() {
        // Act
        Task task1 = new Task("1234567890", "Task Name 1", "Task Description 1");
        Task task2 = new Task("1234567890", "Task Name 2", "Task Description 2");
        taskService.addTask(task1);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    public void shouldDeleteTaskWithValidID() {
        // Act
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("1234567890");

        // Assert
        assertFalse(taskService.getTasks().containsKey("1234567890"));
    }

    @Test
    public void shouldThrowExceptionWhenDeletingTaskWithInvalidID() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("1234567890"));
    }

    @Test
    public void shouldUpdateTaskWithValidID() {
        // Act
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);

        task.setName("New Task Name");
        task.setDescription("New Task Description");
        taskService.updateTask("1234567890", task);

        // Assert
        assertEquals("New Task Name", taskService.getTasks().get("1234567890").getName());
        assertEquals("New Task Description", taskService.getTasks().get("1234567890").getDescription());
    }

    @Test
    public void shouldThrowExceptionWhenUpdatingTaskWithInvalidID() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask("1234567890", new Task("1234567890", "New Task Name", "New Task Description")));
    }
}
