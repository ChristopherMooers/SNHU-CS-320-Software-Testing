package task;

public class Task {
	
	// ID is not updatable
	private final String taskId;
	
	private String name;
	private String description;
	
	// Limits
	private static final int TASK_ID_MAX = 10;
	private static final int NAME_MAX = 20;
	private static final int DESC_MAX = 50;
	
	/* Creates a Task with required fields
	 * 
	 * @param taskId required, not null, length <= 10
	 * @param name required, not null, length <= 20
	 * @param description required, not null, length <= 50
	 * 
	 */
	public Task(String taskId, String name, String description) {
		
		validateTaskId(taskId);
		validateName(name);
		validateDescription(description);
		
		this.taskId = taskId;
		this.name = name;
		this.description = description; 
	}
		
	// Accessors
	public String getTaskId() {
		return taskId;
	}
		
	public String getName() {
		return name;
	}
		
	public String getDescription() {
		return description;
	}
		
	//Mutators that can be updated with validation
	public void setName(String name) {
		validateName(name);
		this.name = name;
	}
		
	public void setDescription(String description) {
		validateDescription(description);
		this.description = description;
	}
		
	// Validation helpers
	private static void validateTaskId(String taskId ) {
		if (taskId == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
		}
			
		if (taskId.length() > TASK_ID_MAX) {
			throw new IllegalArgumentException("Task ID cannot be longer than " + TASK_ID_MAX + ".");
		}
	}
		
	private static void validateName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
			
		if (name.length() > NAME_MAX) {
			throw new IllegalArgumentException("Name cannot be longer than " + NAME_MAX + ".");
		}
	}
		
	private static void validateDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Description cannot be null.");
		}
			
		if (description.length() > DESC_MAX) {
			throw new IllegalArgumentException("Description cannot be longer than " + DESC_MAX + ".");
		}
	}
}

