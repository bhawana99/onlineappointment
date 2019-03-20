package project.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Department;
import project.com.bo.Doctor;
import project.com.dao.DepartmentDao;
import project.com.dao.DoctorDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class AddController
 */
public class UploadReportJspController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadReportJspController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DoctorDao dao = DaoFactory.getDoctorDao();
		List<Doctor> doctorlist = dao.getAll();
		
		if(doctorlist!=null){
			request.setAttribute("doctorlist", doctorlist);
			RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
		    rd.forward(request, response);
		}
		
		
	}

}
