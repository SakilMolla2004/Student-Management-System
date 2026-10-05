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

import ams.dao.DaoAdmin;
import ams.dao.DaoLogin;
import ams.model.ModelAdmin;
import ams.model.ModelTeacher;
import ams.model.ModelUser;


public class TeachersTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object teachers;
       
    
    public TeachersTable() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    }
	    
	    String userName = session.getAttribute("userName").toString();
	  List<ModelAdmin>teacher=DaoAdmin.getAllDataByTeachers(userName);
	  request.setAttribute("teacher", teacher);
	  teachers=DaoAdmin.getImageByTeacherName(userName);
	  request.setAttribute("teachers", teachers);

	  
	  
	  

	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/teachers_table.jsp");
	rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
