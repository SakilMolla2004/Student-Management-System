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

import ams.dao.DaoSubject;
import ams.model.ModelSubject;


public class SubjectView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubjectView() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
		    if (session == null || session.getAttribute("userName") == null) {
		    	response.sendRedirect("Logout");
		    	return;
		    	}
		List<ModelSubject>list=DaoSubject.getallSubject();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/subjects.jsp");
		rd.forward(request, response);
		
		}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
	}

}
