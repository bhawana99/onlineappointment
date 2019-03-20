package project.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class ViewAllRegisteredPatient
 */
public class ViewAllRegisteredPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PatientDao dao = DaoFactory.getPatientDao();
		List<Patient> patientList = dao.get_all_patient();
		
		request.setAttribute("patientList", patientList);
		RequestDispatcher rd = request.getRequestDispatcher("view_registered_patient.jsp");
		rd.forward(request, response);
		
	}

}
