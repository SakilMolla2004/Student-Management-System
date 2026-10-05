package ams.servlet;

import java.io.IOException;

import ams.dao.DaoAdmin;
import ams.dao.DaoLogin;
import ams.model.ModelAdmin;
import ams.model.ModelUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userName") == null) {
			request.setAttribute("msg", "Welcome to Login");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("WEB-INF/jsp/login.jsp");
		return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		ModelUser user = DaoLogin.authenticate(userName, password, role);
		
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", user.getUsername());
			session.setAttribute("name", user.getName());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("role", role);
			if (role.equals("teacher")) {
				response.sendRedirect("TeachersTable");

			} else if (role.equals("student")) {
				response.sendRedirect("StudentsTable");

			} else if (role.equals("superadmin")) {
				response.sendRedirect("Dashboard");
			}

			return;
		} else {
			response.sendRedirect("Login");
			return;
		}

	}
}
