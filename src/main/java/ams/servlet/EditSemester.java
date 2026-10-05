package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import ams.dao.DaoSemester;
import ams.model.ModelSemester;


public class EditSemester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditSemester() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    	}
		String sem_id=request.getParameter("sem_id");
		ModelSemester me=DaoSemester.getBySemesterId(Integer.parseInt(sem_id));
		request.setAttribute("me", me);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/semester_edit.jsp");
		rd.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sem_id=request.getParameter("sem_id");
		String sem_code=request.getParameter("sem_code");
		String sem_name=request.getParameter("sem_name");
		String year_code=request.getParameter("year_code");
		 int i = DaoSemester.UpdateSemester(sem_code, sem_name, year_code, Integer.parseInt(sem_id));

		if(i>0) {
			request.setAttribute("msg", "Update Successful");
		}
		else{
			request.setAttribute("msg", "Update failed");
		}
		response.sendRedirect("Semesters");
	}

}
