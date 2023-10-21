import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (getTasks().containsKey(task.getId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }

        getTasks().put(task.getId(), task);
    }

    public void deleteTask(String taskId) {
        if (!getTasks().containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }

        getTasks().remove(taskId);
    }

    public void updateTask(String taskId, Task task) {
        if (!getTasks().containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }

        Task existingTask = getTasks().get(taskId);

        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
    }

    public Task getTask(String taskId) {
        if (!getTasks().containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }

        return getTasks().get(taskId);
    }

	public Map<String, Task> getTasks() {
		return tasks;
	}

	public void setTasks(Map<String, Task> tasks) {
		this.tasks = tasks;
	}
}
