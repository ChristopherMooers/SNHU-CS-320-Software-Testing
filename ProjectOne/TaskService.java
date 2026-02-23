package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	// In-memory storage: key = taskId, value = Task object
	private final Map<String, Task> tasks = new HashMap<>();
	
	/*
	 * Adds a task to the service with unique taskId
	 * 
	 * @param task task to add
	 */
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		
		String id = task.getTaskId();
		
		// Unique Id requirement
		if (tasks.containsKey(id)) {
			throw new IllegalArgumentException("Task ID already exists: " + id + ".");
		}
		
		tasks.put(id,  task);
	}
	
	/*
	 * Deletes a task by taskId
	 * 
	 * @param taskId id of task to delete
	 */
	public void deleteTask(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
		}
		
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID not found: " + taskId + ".");
		}
		
		tasks.remove(taskId);
	}
	
	/*
	 * Updates the name field of a task by taskId
	 * 
	 * @param taskId id of task to update
	 * @param newName new name(validated by Task)
	 */
	public void updateTaskName(String taskId, String newName) {
		Task t = getExistingTask(taskId);
		t.setName(newName);
	}
	
	/*
	 * Updates the description field of a task by taskId
	 * 
	 * @param taskId id of task to update
	 * @param newDescription new description (validated by Task)
	 */
	public void updateTaskDescription(String taskId, String newDescription) {
		Task t= getExistingTask(taskId);
		t.setDescription(newDescription);
	}
	
	/*
	 * Get task if it exists, otherwise throw
	 */
	private Task getExistingTask(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
		}
		
		Task t = tasks.get(taskId);
		if (t == null) {
			throw new IllegalArgumentException("Task ID not found: " + taskId + ".");
		}
		
		return t;
	}
	
	/*
	 * For tests/debugging
	 */
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
}
