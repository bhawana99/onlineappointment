package project.com.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Patient;
import project.com.dao.DoctorDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class TodayAppointmentServlet
 */
public class TodayAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodayAppointmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorDao doctorDao = DaoFactory.getDoctorDao();
		List<Patient> list = new ArrayList<Patient>();
		list = doctorDao.getTodayAppointment();
		RequestDispatcher rd = request.getRequestDispatcher("todayappointmentview.jsp");
		request.setAttribute("patientlist",list);
		rd.forward(request, response);
	}

}
