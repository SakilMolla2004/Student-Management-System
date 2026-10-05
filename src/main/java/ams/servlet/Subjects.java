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

import ams.dao.DaoDepartment;
import ams.dao.DaoSemester;
import ams.dao.DaoSubject;
import ams.model.ModelDepartment;
import ams.model.ModelSemester;
import ams.model.ModelSubject;


public class Subjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Subjects() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	 HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    	}
	    List<ModelDepartment> list  = DaoDepartment.getAlldepartment();
		request.setAttribute("deptList", list);
		List<ModelSemester> list1=DaoSemester.getAllSemester();
		request.setAttribute("List", list1);
		
	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/subject_registration.jsp");	
	rd.forward(request, response);

}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub_name=request.getParameter("sub_name");
		String sem_code=request.getParameter("sem_code");
		String sub_code=request.getParameter("sub_code");
		String dept_code=request.getParameter("dept_code");
		ModelSubject ms=new ModelSubject();
		ms.setSub_name(sub_name);
		ms.setSem_code(sem_code);
		ms.setSub_code(sub_code);
		ms.setDept_code(dept_code);
		int i=DaoSubject.saveSubject(ms);
		if(i>0) {
			request.setAttribute("msg", "Subject registration successful");
		}
		else {
			request.setAttribute("msg", "Subject registration faild");
		}
		
		doGet(request, response);	
		
		
	}

}
