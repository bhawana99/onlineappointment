package project.com.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class ChagePasswordController
 */
public class ChagePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String oldPassword = request.getParameter("old_password");
		String newPassword = request.getParameter("new_password");
		String confirmPassword = request.getParameter("confirm_new_password");
		boolean isValid;
		String msg = null;
		
		PatientDao dao = DaoFactory.getPatientDao();
		try {
		   isValid = dao.changePasswordValidate(email, oldPassword, newPassword, confirmPassword);
		} catch (Exception e) {
			msg = e.getMessage();
		}
		
		if(msg!=null){
			HttpSession session = request.getSession(false);
			session.setAttribute("message", msg);
			response.sendRedirect("password_change.jsp");
		}else{
			boolean isChanged = dao.changePassword(email, newPassword);
			String message = "password successfully changed";
			HttpSession session = request.getSession(false);
			session.setAttribute("message", message);
			response.sendRedirect("patientprofile.jsp");
		}
		
	}

}
