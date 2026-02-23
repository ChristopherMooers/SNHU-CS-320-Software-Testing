package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
	
	@Test
	void testTaskCreationValid() {
		
		Task task = new Task("12345", "Do homework", "Finish CS 320 Milestone");
		assertEquals("12345", task.getTaskId());
		assertEquals("Do homework", task.getName());
		assertEquals("Finish CS 320 Milestone", task.getDescription());
	}
	
	@Test
	void testTaskIdNullThrows() {
		
		assertThrows(IllegalArgumentException.class, () -> 
		new Task(null, "Name", "Description"));  
	}
	
	@Test
	void testTaskIdTooLongThrows() {
		assertThrows(IllegalArgumentException.class, () ->
		new Task("12345678901", "Name", "Description")); // 11 chars
	}
	
	@Test
	void testNameNullThrows() {
		
		assertThrows(IllegalArgumentException.class, () ->
		new Task("123", null, "Description")); 
	}
	
	@Test
	void testNameTooLongThrows() {
		
		assertThrows(IllegalArgumentException.class, () ->
		new Task("123", "1234556789012345678901", "Description")); // 21 chars
	}
	
	@Test
	void testDescriptionNullThrows() {
		
		assertThrows(IllegalArgumentException.class, () ->
		new Task("123", "Name", null));
	}
	
	@Test 
	void testDescriptionTooLongThrows() {
		
		assertThrows(IllegalArgumentException.class, () ->
		new Task("123", "Name", "123456789012345678901234567890123456789012345678901")); // 51 chars
	}
	
	@Test
	void testSetNameValid() {
        
		Task task = new Task("1", "Old", "Desc");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    void testSetNameInvalidThrows() {
        
    	Task task = new Task("1", "Old", "Desc");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("123456789012345678901")); // 21
    }

    @Test
    void testSetDescriptionValid() {
        
    	Task task = new Task("1", "Name", "Old");
        task.setDescription("New description");
        assertEquals("New description", task.getDescription());
    }

    @Test
    void testSetDescriptionInvalidThrows() {
        
    	Task task = new Task("1", "Name", "Old");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () ->
                task.setDescription("123456789012345678901234567890123456789012345678901")); // 51
    }

}
