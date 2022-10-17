/*
 * Author: Joshua Perez
 * Organization: SNHU
 * Class: CS-320-T1183 Software Test Automation& QA
 */

package main.java.com.snhu.contactService;

public class Task {

	// Unique task ID, no more than 10 char. Not null, not update-able
	String taskId;
	
	// Name field, no more than 20 char. Not null
	String taskName;
	
	// Description field, no more than 50 char. Not null
	String taskDesc;
	
	
	public Task() {
		taskId = "INITIAL";
		taskName = "INITIAL";
		taskDesc = "INITIAL DESCRIPTION";
	}
	  
	public Task(String taskId) {
		checkTaskId(taskId);
		taskName = "INITIAL";
		taskDesc = "INITIAL DESCRIPTION";
	}

	public Task(String taskId, String taskName) {
		checkTaskId(taskId);
		setTaskName(taskName);
		taskDesc = "INITIAL DESCRIPTION";
	}	
	
	public Task (String taskId, String taskName, String taskDesc) {
		checkTaskId (taskId);
		setTaskName (taskName);
		setTaskDesc (taskDesc);
	}
	
	public final String getTaskId() {
		return taskId;
	}
	
	private void checkTaskId (String taskId) {
		// Not null, no more than 10 char. 
		if (taskId == null || taskId.length () > 10) {
			throw new IllegalArgumentException ("Error: Invalid task ID");
		} else {
			this.taskId = taskId;
		}
	}
	
	
	// Getters and Setters - Task Name
	public final String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		// Not null, no more than 20 char. 
		if (taskName == null || taskName.length () > 20) {
			throw new IllegalArgumentException ("Error: Invalid task name");
		} else {
			this.taskName = taskName;
		}
	}	
	
	
	// Getters and Setters - Task Description field
	public String getTaskDesc() {
		return taskDesc;
	}
	
	public void setTaskDesc(String taskDesc) {
		// Not null, no more than 50 char.
		if (taskDesc == null || taskDesc.length () > 50) {
			throw new IllegalArgumentException ("Error: Invalid task description");
		} else {
		this.taskDesc = taskDesc;
		}
	}

}
