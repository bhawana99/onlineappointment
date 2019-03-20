package project.com.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.bo.Doctor;
import project.com.dao.DoctorDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String loginId = request.getParameter("loginId");
          String loginPassword = request.getParameter("loginPassword");
          
          DoctorDao doctorDao = DaoFactory.getDoctorDao();
          Doctor doctor = doctorDao.validLogin(loginId, loginPassword);
          if(doctor != null){
        	  HttpSession session = request.getSession();
        	  session.setAttribute("doctor", doctor);
        	  response.sendRedirect("dashboard.jsp");
          }else {
     		 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		 request.setAttribute("error_msg", "invalid user or password");
    		 rd.forward(request, response);
    	 }
	}

}
