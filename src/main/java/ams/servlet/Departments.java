package ams.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import ams.dao.DaoDepartment;
import ams.model.ModelDashboard;
import ams.model.ModelDepartment;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Departments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Departments() {
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
		
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/departments.jsp");
		rd.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_name=request.getParameter("deptname");
		String dept_code=request.getParameter("deptcode");
		
		ModelDepartment md=new ModelDepartment();
		md.setDept_name(dept_name);
		md.setDept_code(dept_code);
		
	        int a = DaoDepartment.saveDepartment(md);
	        if (a > 0) {
	            request.setAttribute("msg", "Department Registration Successful.");
	        } else {
	        	request.setAttribute("msg", "Department Registration Failed.");
	        }
	        doGet(request, response);
		
	}

}
