package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;

@WebServlet("/delete")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteTodoServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int todoID = Integer.parseInt(request.getParameter("todoID").toString());
		TodoDao todoDao = new TodoDao();
		todoDao.deleteTodo(todoID);
		response.sendRedirect("todos");

	}

}
