package ams.servlet;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.ha.backend.Sender;

import ams.dao.DaoSemester;
import ams.dao.DaoSubject;
import ams.model.ModelSemester;
import ams.model.ModelSubject;


public class Semesters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Semesters() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ModelSemester> list=DaoSemester.getAllSemester();
		request.setAttribute("List", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/semesters.jsp");
		rd.forward(request, response);
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sem_code=request.getParameter("sem_code");
		String sem_name=request.getParameter("sem_name");
		String year_code=request.getParameter("year_code");
		
		ModelSemester me=new ModelSemester();
		me.setSem_code(sem_code);
		me.setSem_name(sem_name);
		me.setYear_code(year_code);
		int i=DaoSemester.saveSemester(me);
		if(i>0) {
			request.setAttribute("msg", "Registration is Successfull.");
		}
		else {
			request.setAttribute("msg", "Registration is Failed.");
		}
		doGet(request, response);
	}

}
