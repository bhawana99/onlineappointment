package project.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Report;
import project.com.dao.DoctorDao;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class GetReportServlet
 */
public class GetReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String doc_id = request.getParameter("doctorId");
		
		DoctorDao doctorDao = DaoFactory.getDoctorDao();
		List<Report> list = new ArrayList<Report>();
		list = doctorDao.getReport(doc_id);
		
		List<String> namelist = new ArrayList<String>();
		
		for (Report reportlist : list) {
			Long p_id = reportlist.getP_id();
			PatientDao patientdao = DaoFactory.getPatientDao();
			String name = patientdao.get_patient_name(p_id);
			namelist.add(name);
		}
		RequestDispatcher rd = request.getRequestDispatcher("getreport.jsp");
		request.setAttribute("reportlist",list);
		request.setAttribute("namelist",namelist);
		
		rd.forward(request, response);
	}


}
