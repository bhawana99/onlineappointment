package project.com.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.bo.Admin;
import project.com.dao.AdminDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("userid");
		String password = request.getParameter("password");
		Admin admin = null;
		
		AdminDao dao = DaoFactory.getAdminDao();
		admin = dao.login_admin(email, password);
		
		if(admin!=null){
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("admin_dashboard.jsp");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("administration.jsp");
			request.setAttribute("message", "Invalid id/password");
			rd.forward(request,response);
		}
		
	}

}
