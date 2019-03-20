package project.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Department;
import project.com.bo.Patient;
import project.com.dao.DepartmentDao;
import project.com.dao.DoctorDao;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class ViewAllAppointmentController
 */
public class ViewAllAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PatientDao patient_dao = DaoFactory.getPatientDao();
		DepartmentDao department_dao = DaoFactory.getDepartmentDao();
		DoctorDao doctor_dao = DaoFactory.getDoctorDao();
		
		List<Patient> patientList = patient_dao.view_all_appointment();
		List<String> departmentList = new ArrayList<String>();
		List<String> doctorList = new ArrayList<String>();
		
		for(Patient patient : patientList){
			String doctor_name = doctor_dao.getDoctorName(patient.getD_id());
		    String dept_name = department_dao.getDepartmentName(patient.getDept_id());
		    
		    departmentList.add(dept_name);
		    doctorList.add(doctor_name);
		}
		
		request.setAttribute("patient", patientList);
		request.setAttribute("department", departmentList);
		request.setAttribute("doctor", doctorList);
		RequestDispatcher rd = request.getRequestDispatcher("view_appointment_details.jsp");
		rd.forward(request, response);
		
	}

}
