package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Todo;
import model.User;
import util.DbUtil;

public class TodoDao {
	private Connection connection;

	// Gets All ToDos from DB with given userID.
	public List<Todo> getAllTodos(int userID) {
		List<Todo> TodoList = new ArrayList<Todo>();

		try {
			String sql = "select * from todos where user_id=?";
			connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, userID);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Todo todoObj = new Todo(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getDate(5));

				if (!TodoList.contains(todoObj)) {
					TodoList.add(todoObj);
				}
			}
			return TodoList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Adds new ToDo into database.
	public void addToDo(int userID, String description, LocalDate dueDate) {

		try {
			String sql = "insert into todos(user_id,description,due_date) values (?,?,?)";
			connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, userID);
			st.setString(2, description);
			st.setObject(3, dueDate);
			st.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	//Deletes ToDo from database.
	public void deleteTodo(int todoID) {

		String sql = "DELETE FROM todos WHERE todos_id=?";

		try {
			connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, todoID);
			st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//Updates ToDo.
	public void updateToDo(String description, LocalDate dueDate, int todoID) {
		String sql = "UPDATE todos SET description=?,due_date=? WHERE todos_id=?";
		try {
			connection = DbUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, description);
			st.setObject(2, dueDate);
			st.setInt(3, todoID);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
