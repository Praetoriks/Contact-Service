/*
 * Author: Joshua Perez
 * Organization: SNHU
 * Class: CS-320-T1183 Software Test Automation& QA
 */

package main.java.com.snhu.contactService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TaskService {
	
	private final List<Task> taskServiceList = new ArrayList<>();
	
	// Unique task ID string that is not update-able 
	private String newUniqueId( ) {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	// Search through the array for a task
	private Task findTask(String taskId) throws Exception {
		int index = 0;
		while (index < taskServiceList.size()) {
		      if (taskId.equals(taskServiceList.get(index).getTaskId())) {
		        return taskServiceList.get(index);
		      }
		      index++;
		    }
		    throw new Exception("The Task does not exist!");
	}
	
	public void newTask() {
		Task task = new Task(newUniqueId());
		taskServiceList.add(task);
	}
	
	public void newTask(String name) {
		Task task = new Task(newUniqueId(), name);
		taskServiceList.add(task);
		  }

	public void newTask(String name, String description) {
		Task task = new Task(newUniqueId(), name, description);
		taskServiceList.add(task);
	}
	
	// Delete a task from the array
	public void delTask(String taskId) throws Exception {
		taskServiceList.remove(findTask(taskId));
	}
	
	// Update a task name in the array. Update-able as per requirement
	public void updateTaskName (String taskId, String taskName) throws Exception {
		findTask(taskId).setTaskName(taskName);
	}

	// Update a task description in the array. Update-able as per requirement
	public void updateTaskDesc (String taskId, String taskDesc) throws Exception {
		findTask(taskId).setTaskDesc(taskDesc);
	}
	
	public List <Task> getTaskServiceList() {
		return taskServiceList;
	}
}		