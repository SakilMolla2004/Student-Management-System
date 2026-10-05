package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



import ams.dao.DaoSubject;
import ams.model.ModelSubject;


public class EditSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditSubject() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub_id=request.getParameter("sub_id");
		ModelSubject ms=DaoSubject.getSubjectById(Integer.parseInt(sub_id));
		request.setAttribute("ms", ms);
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/jsp/subject_edit.jsp");
		rd.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub_id=request.getParameter("sub_id");
		String sub_name=request.getParameter("sub_name");
		String sem_code=request.getParameter("sem_code");
		String sub_code=request.getParameter("sub_code");
		String dept_code=request.getParameter("dept_code");
		int i=DaoSubject.updateSubject(sub_name, sem_code, sub_code, dept_code, Integer.parseInt(sub_id));
		if(i>0) {
			request.setAttribute("msg", "Upadate Successful");
		}
		else {
			request.setAttribute("msg", "Update Failed");
		}
		response.sendRedirect("SubjectView");
		
		}

}
