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
import ams.dao.DaoYear;
import ams.model.ModelYear;


public class Year extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Year() {
        super();
         }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    	}
List<ModelYear> list=DaoYear.getAllYears();
request.setAttribute("YearList", list);
RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/years.jsp");
rd.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String year_name=request.getParameter("year_name");
	String year_code=request.getParameter("year_code");
	ModelYear my=new ModelYear();
	my.setYear_name(year_name);
	my.setYear_code(year_code);
	int i=DaoYear.SaveYear(my);
	if(i>0) {
		request.setAttribute("msg", "Registration Successful");
	}
	else {
		request.setAttribute("msg", "Registration Failed");
	}
	doGet(request, response);
	
	}

}
