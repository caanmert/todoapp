package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDao();
	
	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (dao.LoginCheck(username, password)) {

			String userID = dao.getUserId(username);
			request.getSession().setAttribute("userID", userID);
			response.sendRedirect("todos");

		} else {
			request.setAttribute("errorMessage", "Unknown Login, try again");
			request.getRequestDispatcher("/login.jsp").include(request, response);
		}

	}

}