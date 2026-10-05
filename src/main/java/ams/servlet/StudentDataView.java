package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ams.dao.DaoStudent;
import ams.dao.DaoSubject;
import ams.dao.DaoTeacher;
import ams.model.ModelStudent;
import ams.model.ModelSubject;
import ams.model.ModelTeacher;

public class StudentDataView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentDataView() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s_id = request.getParameter("s_id");

		ModelStudent st = DaoStudent.getStudentById(Integer.parseInt(s_id));
		List<ModelSubject> lms = DaoSubject.getSubjectByStudent(st);
		List<ModelTeacher> lmt = new ArrayList<ModelTeacher>();
		for (int i = 0; i < lms.size(); i++) {
			ModelTeacher mt = DaoTeacher.getTeacherBySubjetCode(lms.get(i).getSub_code());
			lmt.add(mt);
		}
		request.setAttribute("lmt", lmt);

		request.setAttribute("lms", lms);
		request.setAttribute("st", st);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/student_dataview.jsp");
	
		rd.forward(request, response);
		//System.out.println("Sakil");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
