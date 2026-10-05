package ams.servlet;

import java.io.IOException;

import ams.dao.DaoDepartment;
import ams.model.ModelDashboard;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Dashboard() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("userName") == null) {
	    	response.sendRedirect("Logout");
	    	return;
	    }
	    ModelDashboard md=DaoDepartment.count();
		request.setAttribute("md", md);
		ModelDashboard mds=DaoDepartment.countSub();
		request.setAttribute("mds", mds);
		ModelDashboard mdt=DaoDepartment.countTeacher();
		request.setAttribute("mdt", mdt);
		ModelDashboard mdsem=DaoDepartment.countSem();
		request.setAttribute("mdsem", mdsem);
		ModelDashboard mdyear=DaoDepartment.countYear();
		request.setAttribute("mdyear", mdyear);
		ModelDashboard mdstudent=DaoDepartment.countStudent();
		request.setAttribute("mdstudent", mdstudent);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp");
		rd.forward(request, response);
	}

}
