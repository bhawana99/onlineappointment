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
 * Servlet implementation class ViewDepartmentController
 */
public class ViewDepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  DepartmentDao dao = DaoFactory.getDepartmentDao();
	  List<Department> deptList = dao.getAll();
	  
	  RequestDispatcher rd = request.getRequestDispatcher("view_dept.jsp");
	  request.setAttribute("deptlist", deptList);
	  rd.forward(request, response);
	}

}
