package model;

import java.util.Date;

public class Todo {
	
	private int todos_id;
	private String description;
	private Date createdDate;
	private Date dueDate;
	private static int counter = 1;
	
	
	public Todo() {}
	public Todo(int todos_id,String description, Date createdDate, Date dueDate) {
		super();
		this.todos_id = todos_id;
		this.description = description;
		this.createdDate = createdDate;
		this.dueDate = dueDate;
	}
	public long getTodos_id() {
		return todos_id;
	}
	public void setTodos_id(int todos_id) {
		this.todos_id = todos_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "ToDo [todos_id=" + todos_id + ", description=" + description + ", createdDate=" + createdDate
				+ ", dueDate=" + dueDate + "]";
	}
	

}
