package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userdao = new UserDao();

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User(request.getParameter("firstname"), request.getParameter("lastname"),
				request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
		if (!userdao.UserExists(user)) {
			request.setAttribute("errorMessage", "Username or email already exists.");
			request.getRequestDispatcher("register.jsp").include(request, response);
		} else {
			userdao.addUser(user);
			request.setAttribute("successMessage", "Succesfully registered Login now!");
			request.getRequestDispatcher("login").forward(request, response);
		}
	}

}
