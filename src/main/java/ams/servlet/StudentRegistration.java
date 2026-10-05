package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import ams.dao.DaoDepartment;
import ams.dao.DaoSemester;
import ams.dao.DaoStudent;
import ams.dao.DaoSubject;
import ams.model.ModelDepartment;
import ams.model.ModelSemester;
import ams.model.ModelStudent;
import ams.model.ModelSubject;


public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentRegistration() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ModelSemester> list=DaoSemester.getAllSemester();
		request.setAttribute("List", list);
		List<ModelDepartment> list1  = DaoDepartment.getAlldepartment();
		request.setAttribute("deptList", list1);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/student_registration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
