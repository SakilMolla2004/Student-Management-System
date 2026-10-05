package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import ams.dao.DaoStudents;
import ams.model.ModelStudent;


public class StudentsTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentsTable() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userName") == null) {
			response.sendRedirect("Logout");
			return;
		}
		String userName = session.getAttribute("username").toString();
		ModelStudent st=DaoStudents.getStudents(userName);
	
		List<ModelStudent> sts=DaoStudents.getAllStudents(userName);
		
		request.setAttribute("st", st);
		request.setAttribute("Students", sts);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/students_table.jsp");

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
