package project.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.bo.Department;
import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class PatientLoginController
 */
public class PatientLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("patientid");
		String password = request.getParameter("password");
		
		List<Department> dept_list = null;
		List<String> doc_list = null;
		
		PatientDao dao = DaoFactory.getPatientDao();
		Patient patient = dao.login_validate(id, password);
		
		if(patient!=null){
			HttpSession session = request.getSession();
			session.setAttribute("patient", patient);
			session.setAttribute("departmentlist",dept_list);
			session.setAttribute("doctorlist",doc_list);
			response.sendRedirect("getappointment");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("message", "Invalid id/password");
			rd.forward(request,response);
		}
	}

}
