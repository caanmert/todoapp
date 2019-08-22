package main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;

@WebServlet("/add")
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddTodoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TodoDao todoDao = new TodoDao();
		request.getSession().getAttribute("userID");
		int userID = Integer.parseInt(request.getSession().getAttribute("userID").toString());
		String description = request.getParameter("description");
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dueDate = LocalDate.parse(request.getParameter("date"),f);
		
			todoDao.addToDo(userID, description, dueDate);
			response.sendRedirect("todos");
	}
}
