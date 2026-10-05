package ams.servlet;

import java.io.IOException;

import ams.dao.DaoDepartment;
import ams.model.ModelDepartment;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class EditDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditDepartment() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_id = request.getParameter("dept_id");
		ModelDepartment md = DaoDepartment.getDepartmentById(Integer.parseInt(dept_id));
		request.setAttribute("md", md);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/department_edit.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptname = request.getParameter("deptname");
		String deptcode = request.getParameter("deptcode");
		String dept_id = request.getParameter("dept_id");
		int  i = DaoDepartment.updateDept(deptname, deptcode, Integer.parseInt(dept_id));
		if (i>0) {
			request.setAttribute("msg", "Update Successful");
		}else {
			request.setAttribute("msg", "Update Failed");
		}
		response.sendRedirect("Departments");
	}
}
