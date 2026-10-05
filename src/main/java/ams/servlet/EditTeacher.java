package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import ams.dao.DaoDepartment;
import ams.dao.DaoTeacher;
import ams.dao.DaoYear;
import ams.model.ModelDepartment;
import ams.model.ModelTeacher;


public class EditTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditTeacher() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    	}
String T_id=request.getParameter("t_id");
ModelTeacher mt = DaoTeacher.getTeacherById(Integer.parseInt(T_id));
request.setAttribute("mt", mt);
	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/teacher_edit.jsp");
	rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String T_id=request.getParameter("t_id");
		String Sub_code=request.getParameter("s_code");
		String T_name=request .getParameter("t_name");
		String Gender=request.getParameter("gender");
		ModelTeacher mt=new ModelTeacher();
		mt.setSub_code(Sub_code);
		mt.setT_name(T_name);
		mt.setGender(Gender);
		int i = DaoTeacher.updateTeacher(Sub_code, T_name, Gender, Integer.parseInt(T_id));
		if(i>0) {
			request.setAttribute("msg", "Update Successful");
		}
		else {
			request .setAttribute("msg", "Update Failed");
		}
		response.sendRedirect("TeacherRegistration");
	}

}
