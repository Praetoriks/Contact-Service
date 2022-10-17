package test.java.com.snhu.contactService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.snhu.contactService.Task;

class TaskTest {

  private String id, name, description;
  private String tooLongId, tooLongName, tooLongDescription;

  @BeforeEach
  void setUp() {
    id = "0987654321";
    name = "This fit req exactly";
    description = "The object has a required description.";
    tooLongId = "111222333444555666777888999";
    tooLongName = "This task name is purposely too long in order to break the requirements.";
    tooLongDescription = "This description is purposely set to be too long in order to break the appointment requirements, therefore I will ramble.";
  }

  @Test
  void getTaskIdTest() {
    Task task = new Task(id);
    Assertions.assertEquals(id, task.getTaskId());
  }

  @Test
  void getNameTest() {
    Task task = new Task(id, name);
    Assertions.assertEquals(name, task.getTaskName());
  }

  @Test
  void getDescriptionTest() {
    Task task = new Task(id, name, description);
    Assertions.assertEquals(description, task.getTaskDesc());
  }

  @Test
  void setNameTest() {
    Task task = new Task();
    task.setTaskName(name);
    Assertions.assertEquals(name, task.getTaskName());
  }

  @Test
  void setDescriptionTest() {
    Task task = new Task();
    task.setTaskDesc(description);
    Assertions.assertEquals(description, task.getTaskDesc());
  }

  @Test
  void TaskIdTooLongTest() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(tooLongId));
  }

  @Test
  void setTooLongNameTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskName(tooLongName));
  }

  @Test
  void setTooLongDescriptionTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc(tooLongDescription));
  }

  @Test
  void TaskIdNullTest() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
  }

  @Test
  void TaskNameNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
  }

  @Test
  void TaskDescriptionNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc(null));
  }
}