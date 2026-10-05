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

import ams.dao.DaoSemester;
import ams.dao.DaoStudent;
import ams.model.ModelSemester;
import ams.model.ModelStudent;
import ams.util.FileUploadHelper;

@MultipartConfig
public class Students extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Students() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
		    if (session == null || session.getAttribute("userName") == null) {
		    	response.sendRedirect("Logout");
		    	return;
		    	}
		List<ModelStudent>list=DaoStudent.getAllStudent();
		request.setAttribute("List", list);
		
	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/students.jsp");
	rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part filePart = request.getPart("file");


        String fileName = FileUploadHelper.uploadFile(filePart);
		String sem_code=request.getParameter("sem_code");	
		String name=request.getParameter("name");	
		String gender=request.getParameter("gender");	
		String address=request.getParameter("address");	
		String dept_code=request.getParameter("dept_code");
		
		
		
		ModelStudent st=new ModelStudent();
		st.setSem_code(sem_code);
		st.setName(name);
		st.setGender(gender);
		st.setAddress(address);
		st.setDept_code(dept_code);
		st.setImage(fileName);
		int i=DaoStudent.saveStudent(st);
		if(i>0) {
			request.setAttribute("msg", "Registration is successfull");
			
		}
		else {
			request.setAttribute("msg", "Registration is Failed");
		}
		
		doGet(request, response);
		}

}
