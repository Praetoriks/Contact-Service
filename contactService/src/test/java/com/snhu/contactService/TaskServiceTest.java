package test.java.com.snhu.contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.com.snhu.contactService.TaskService;

class TaskServiceTest {

  private String id, name, description;
  private String tooLongName, tooLongDescription;

  @BeforeEach
  void setUp() {
    id = "0987654321";
    name = "This fit req exactly";
    description = "The object has a required description.";
    tooLongName = "This task name is purposely too long in order to break the requirements.";
    tooLongDescription = "This description is purposely set to be too long in order to break the appointment requirements, therefore I will ramble.";
  }

  @Test
  void newTaskTest() {
    TaskService service = new TaskService();
    service.newTask();
    Assertions.assertNotNull(service.getTaskServiceList().get(0).getTaskId());
    Assertions.assertNotEquals("init", service.getTaskServiceList().get(0).getTaskId());
  }

  @Test
  void newTaskNameTest() {
    TaskService service = new TaskService();
    service.newTask(name);
    Assertions.assertNotNull(service.getTaskServiceList().get(0).getTaskName());
    Assertions.assertEquals(name, service.getTaskServiceList().get(0).getTaskName());
  }

  @Test
  void newTaskDescriptionTest() {
    TaskService service = new TaskService();
    service.newTask(name, description);
    Assertions.assertNotNull(service.getTaskServiceList().get(0).getTaskDesc());
    Assertions.assertEquals(description, service.getTaskServiceList().get(0).getTaskDesc());
  }

  @Test
  void newTaskTooLongNameTest() {
    TaskService service = new TaskService();
    Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(tooLongName));
  }

  @Test
  void newTaskTooLongDescriptionTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.newTask(name, tooLongDescription));
  }

  @Test
  void newTaskNameNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
  }

  @Test
  void newTaskDescriptionNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.newTask(name, null));
  }

  @Test
  void deleteTaskTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertEquals(1, service.getTaskServiceList().size());
    service.delTask(service.getTaskServiceList().get(0).getTaskId());
    assertEquals(0, service.getTaskServiceList().size());
  }

  @Test
  void deleteTaskNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertEquals(1, service.getTaskServiceList().size());
    assertThrows(Exception.class, () -> service.delTask(id));
    assertEquals(1, service.getTaskServiceList().size());
  }

  @Test
  void updateNameTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    service.updateTaskName(service.getTaskServiceList().get(0).getTaskId(), name);
    assertEquals(name, service.getTaskServiceList().get(0).getTaskName());
  }

  @Test
  void updateDescriptionTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    service.updateTaskDesc(service.getTaskServiceList().get(0).getTaskId(), description);
    assertEquals(description, service.getTaskServiceList().get(0).getTaskDesc());
  }

  @Test
  void updateNameNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertThrows(Exception.class, () -> service.updateTaskName(id, name));
  }

  @Test
  void updateDescriptionNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertThrows(Exception.class, () -> service.updateTaskDesc(id, description));
  }

  @RepeatedTest(4)
  void UuidTest() {
    TaskService service = new TaskService();
    service.newTask();
    service.newTask();
    service.newTask();
    assertEquals(3, service.getTaskServiceList().size());
    assertNotEquals(service.getTaskServiceList().get(0).getTaskId(),
                    service.getTaskServiceList().get(1).getTaskId());
    assertNotEquals(service.getTaskServiceList().get(0).getTaskId(),
                    service.getTaskServiceList().get(2).getTaskId());
    assertNotEquals(service.getTaskServiceList().get(1).getTaskId(),
                    service.getTaskServiceList().get(2).getTaskId());
  }
}