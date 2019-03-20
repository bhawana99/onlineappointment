package project.com.controller;

import java.io.IOException;






import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class PatientSignUpController
 */
public class PatientSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p_email = request.getParameter("email");
		String p_fname = request.getParameter("firstname");
		String p_lname = request.getParameter("lastname");
		String p_password = request.getParameter("password");
		int p_age = Integer.parseInt(request.getParameter("age"));
		String p_contact = request.getParameter("contactno");
		String p_gender = request.getParameter("gender");
		
		Patient patient = new Patient();
		patient.setP_email(p_email);
		patient.setP_fname(p_fname);
		patient.setP_lname(p_lname);
		patient.setP_password(p_password);
		patient.setP_age(p_age);
		patient.setP_contact(p_contact);
		patient.setP_gender(p_gender);
		String error_msg = null;
		
		PatientDao dao = DaoFactory.getPatientDao();
		try {
			boolean condition2 = dao.email_validation(p_email);
			boolean condition1 = dao.patient_validate(patient);
		} catch (Exception e) {
			error_msg = e.getMessage();
		}
		
		if(error_msg!=null){
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		    request.setAttribute("message", error_msg);
		    rd.forward(request, response);
		}else{
			String message = "login here for appointment";
			request.setAttribute("message", message);
			//request.setAttribute("color", "blue");
			boolean isAdded = dao.add_patient(patient);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
	}

}
