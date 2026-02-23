package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for TaskService behaviors.
 */
public class TaskServiceTest {

    @Test
    void testAddTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("A1", "Task", "Description");

        service.addTask(task);

        assertNotNull(service.getTask("A1"));
        assertEquals("Task", service.getTask("A1").getName());
    }

    @Test
    void testAddTaskDuplicateIdThrows() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Task1", "Desc1"));

        assertThrows(IllegalArgumentException.class, () ->
                service.addTask(new Task("A1", "Task2", "Desc2")));
    }

    @Test
    void testDeleteTaskSuccess() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Task", "Desc"));

        service.deleteTask("A1");

        assertNull(service.getTask("A1"));
    }

    @Test
    void testDeleteTaskMissingIdThrows() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("NOPE"));
    }

    @Test
    void testUpdateTaskNameSuccess() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Old", "Desc"));

        service.updateTaskName("A1", "New");

        assertEquals("New", service.getTask("A1").getName());
    }

    @Test
    void testUpdateTaskDescriptionSuccess() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Name", "Old"));

        service.updateTaskDescription("A1", "New description");

        assertEquals("New description", service.getTask("A1").getDescription());
    }

    @Test
    void testUpdateMissingIdThrows() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("NOPE", "Name"));
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskDescription("NOPE", "Desc"));
    }

    @Test
    void testUpdateInvalidValuesThrow() {
        TaskService service = new TaskService();
        service.addTask(new Task("A1", "Name", "Desc"));

        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("A1", null));
        assertThrows(IllegalArgumentException.class, () ->
                service.updateTaskName("A1", "123456789012345678901")); // 21 chars

        assertThrows(IllegalArgumentException.class, () -> service.updateTaskDescription("A1", null));
        assertThrows(IllegalArgumentException.class, () ->
                service.updateTaskDescription("A1",
                        "123456789012345678901234567890123456789012345678901")); // 51 chars
    }
}

