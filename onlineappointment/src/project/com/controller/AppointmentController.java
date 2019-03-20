package project.com.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.bo.Department;
import project.com.bo.Doctor;
import project.com.bo.Patient;
import project.com.bo.Report;
import project.com.dao.DepartmentDao;
import project.com.dao.DoctorDao;
import project.com.dao.PatientDao;
import project.com.dao.ReportDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class AppointmentController
 */
public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		
		
		DepartmentDao dept_dao = DaoFactory.getDepartmentDao();
		DoctorDao doc_dao = DaoFactory.getDoctorDao();
		PatientDao patient_dao = DaoFactory.getPatientDao();
		ReportDao reportDao = DaoFactory.getReportDao();
		
		
		
		
		if(session.getAttribute("departmentlist")==null){
		    //get department
			List<Department> dept = dept_dao.getAll();

			session.setAttribute("departmentlist", dept);
			response.sendRedirect("appointment.jsp");

		}/*else if(request.getParameter("Department").equals("-1")){
			
			session.setAttribute("message", "select valid department");
			response.sendRedirect("appointment.jsp");
			
		}*/else if(session.getAttribute("doctorlist")==null){
			//get doctor 
			String department = request.getParameter("Department");
			
			List<String> doctorlist = doc_dao.getByDepartment(department);
			
			session.setAttribute("selected_department", department);
			session.setAttribute("doctorlist", doctorlist);
			response.sendRedirect("appointment.jsp");
			
		}else{
			//add patient to database
			String department_name = request.getParameter("Department");
			String doctor_name = request.getParameter("doctor");
			
			Patient patient = (Patient)session.getAttribute("patient");
			Doctor doctor = doc_dao.getByName(doctor_name);
			
			Long p_id = patient_dao.generate_patient_id();
			String d_id = doctor.getD_id();
			String dept_id = doctor.getDept_id();
			Date doa = new java.sql.Date((new java.util.Date()).getTime());
			
			patient.setD_id(d_id);
			patient.setDept_id(dept_id);
			patient.setDoa(doa);
			patient.setP_id(p_id);
			patient.setIsDiagnosed("NO");
			
			boolean isAdded = patient_dao.fix_appointment(patient);
			
			List<Report> reportList = reportDao.getReportById(patient.getP_email());
			List<String> doctor_list2 = new ArrayList<String>(); 
   			for(Report report : reportList){
				String doctor_id = report.getD_id();
				String d_name = doc_dao.getDoctorName(doctor_id);
				doctor_list2.add(d_name);
			}
			
			session.setAttribute("reportlist",reportList);
			session.setAttribute("doctor_namelist",doctor_list2);
			response.sendRedirect("patientprofile.jsp");
			
		}
		
	}

}
