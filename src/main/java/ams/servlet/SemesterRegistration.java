package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import ams.dao.DaoSubject;
import ams.dao.DaoYear;
import ams.model.ModelSubject;
import ams.model.ModelYear;


public class SemesterRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SemesterRegistration() {
        super();
       
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<ModelYear> list=DaoYear.getAllYears();
			request.setAttribute("YearList", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/semester_registration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
