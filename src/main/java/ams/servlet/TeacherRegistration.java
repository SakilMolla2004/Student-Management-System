package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

import ams.dao.DaoTeacher;
import ams.model.ModelTeacher;
import ams.util.FileUploadHelper;

@MultipartConfig
public class TeacherRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TeacherRegistration() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    	}
	List<ModelTeacher> list=DaoTeacher.getAllTeacher();
	
	request.setAttribute("List", list);
	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/teachers.jsp");	
	rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file");


        String fileName = FileUploadHelper.uploadFile(filePart);
	String sub_code=request.getParameter("sub_code");
	String t_name=request.getParameter("t_name");
	String gender=request.getParameter("gender");
	
	ModelTeacher mt=new ModelTeacher();
	mt.setT_name(t_name);
	mt.setSub_code(sub_code);
	mt.setGender(gender);
	mt.setImage(fileName);
	int a=DaoTeacher.saveTeacher(mt);
	if(a>0) {
		request.setAttribute("msg", "Registration Successful");
	}
	else {
		request.setAttribute("msg", "Registration Failed");
	}
	doGet(request, response);
	}

}
