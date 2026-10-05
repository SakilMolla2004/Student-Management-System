package ams.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ams.dao.DaoYear;
import ams.model.ModelYear;


public class EditYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditYear() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Y_id=request.getParameter("y_id");
		ModelYear my=DaoYear.getYearById(Integer.parseInt(Y_id));
		request.setAttribute("my", my);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/year_edit.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String Y_id=request.getParameter("y_id");
	String Year_name=request .getParameter("year_name");
	String Year_code=request .getParameter("year_code");
	ModelYear my=new ModelYear();
	my.setYear_name(Year_name);
	my.setYear_code(Year_code);
	int i=DaoYear.updateYear((Year_name), Year_code, Integer.parseInt(Y_id));
	if(i>0) {
		request.setAttribute("msg", "Update Successful");
	}
	else {
		request.setAttribute("msg", "Update Failed");
	}
	doGet(request, response);
	}

}
