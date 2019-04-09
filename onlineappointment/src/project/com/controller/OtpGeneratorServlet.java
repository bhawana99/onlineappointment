package project.com.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;
import sis.com.util.db.*;


/**
 * Servlet implementation class OtpGeneratorServlet
 */
public class OtpGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toEmail = request.getParameter("email");
		int num  = new Random().nextInt(9999) +1000;
		String otp  =""+num+ (new Random().nextInt(65)+26);
		String msg  = "your opt is "+ otp + " this is tour new password kindly change it.";
	    SisEmailUtil.sendMessage(toEmail, "OTP SANJEEVAN HOSPITAL",msg );
	    
	    PatientDao dao = DaoFactory.getPatientDao();
	    dao.changePassword(toEmail, otp);
	    
	     //request.getSession().setAttribute("user_otp", otp);
	    // request.getSession().setAttribute("email",toEmail);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}
