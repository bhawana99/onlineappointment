package project.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Doctor;
import project.com.bo.Report;
import project.com.dao.DoctorDao;
import project.com.dao.PatientDao;
import project.com.dao.ReportDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class ViewReportList
 */
public class ViewReportList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReportDao dao = DaoFactory.getReportDao();
		PatientDao patientdao = DaoFactory.getPatientDao();
		DoctorDao doctorDao = DaoFactory.getDoctorDao();
		
		List<Report> reportList = dao.getAllReport();
		List<String> namelist = new ArrayList<String>();
		List<String> doctor_namelist = new ArrayList<String>();
		
		for (Report reportlist : reportList) {
			Long p_id = reportlist.getP_id();
			String name = patientdao.get_patient_name(p_id);
			namelist.add(name);
			
			String d_id = reportlist.getD_id();
			String doctor_name = doctorDao.getDoctorName(d_id);
			doctor_namelist.add(doctor_name);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("recordlist.jsp");
		request.setAttribute("reportlist",reportList);
		request.setAttribute("namelist",namelist);
		request.setAttribute("doctor_namelist",doctor_namelist);
		rd.forward(request, response);
		
		
	}

}
