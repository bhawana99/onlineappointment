package project.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.bo.Patient;
import project.com.bo.Report;
import project.com.dao.DepartmentDao;
import project.com.dao.DoctorDao;
import project.com.dao.PatientDao;
import project.com.dao.ReportDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class PatientLoginController
 */
public class PatientProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("patientid");
		String password = request.getParameter("password");
		
		PatientDao dao = DaoFactory.getPatientDao();
		ReportDao reportDao = DaoFactory.getReportDao();
		DoctorDao doctorDao = DaoFactory.getDoctorDao();
		
		Patient patient = dao.login_validate(id, password);
		List<Report> reportList = reportDao.getReportById(id);
		List<String> doctor_namelist = new ArrayList<String>();
		
		for(Report report : reportList){
			String d_id = report.getD_id();
			String doctor = doctorDao.getDoctorName(d_id);
			doctor_namelist.add(doctor);
		}
		
		
		if(patient!=null){
			HttpSession session = request.getSession();
			session.setAttribute("patient", patient);
			session.setAttribute("reportlist",reportList);
			session.setAttribute("doctor_namelist",doctor_namelist);
			response.sendRedirect("patientprofile.jsp");
		}else{
			//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("message", "Invalid id/password");
			//rd.include(request,response);
			response.sendRedirect("reportlogin.jsp");
		}
	}

}
