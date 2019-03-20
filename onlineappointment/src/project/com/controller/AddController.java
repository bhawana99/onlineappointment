package project.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Department;
import project.com.dao.DepartmentDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class AddController
 */
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean added=false;
		String id =  request.getParameter("dept_id").trim();
		String name = request.getParameter("dept_name").trim();
		String diseases = request.getParameter("diseases").trim();
		
		DepartmentDao dao = DaoFactory.getDepartmentDao();
		Department d1 = new Department();
		d1.setDept_id(id);
		d1.setDept_name(name);
		d1.setDiseases(diseases);
		
		added=dao.add(d1);
		System.out.println(added);
		if(added){
		response.sendRedirect("viewdept");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("add_dept.jsp");
			request.setAttribute("message", "department already exists");
            rd.forward(request, response);
		}
	}

}
