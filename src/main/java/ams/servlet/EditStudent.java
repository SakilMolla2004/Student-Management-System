package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ams.dao.DaoStudent;
import ams.dao.DaoSubject;
import ams.dao.DaoTeacher;
import ams.model.ModelStudent;
import ams.model.ModelSubject;
import ams.model.ModelTeacher;

public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    	}
		String s_id = request.getParameter("s_id");
		ModelStudent st = DaoStudent.getStudentById(Integer.parseInt(s_id));
		request.setAttribute("st", st);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/student_edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sem_code = request.getParameter("sem_code");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String dept_code = request.getParameter("dept_code");
		String s_id = request.getParameter("s_id");
		int i = DaoStudent.updateStudent(sem_code, name, gender, address, dept_code, Integer.parseInt(s_id));
		if (i > 0) {
			request.setAttribute("msg", "Update  Successful");
		} else {
			request.setAttribute("msg", "Update Falied");
		}
		response.sendRedirect("Students");
	}

}
