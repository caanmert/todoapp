package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;

@WebServlet("/todos")
public class ListTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoDao todo = new TodoDao();

	public ListTodoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().getAttribute("userID");
		int userID = Integer.parseInt(request.getSession().getAttribute("userID").toString());
		request.setAttribute("todos", todo.getAllTodos(userID));
		request.getRequestDispatcher("/WEB-INF/todos.jsp").forward(request, response);
	}

}
