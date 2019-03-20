package project.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.dao.FeedbackDao;
import project.com.dao.ReportDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class DeleteFeedBackController
 */
public class DeleteFeedBackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFeedBackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isDeleted=false;
		Long id = Long.parseLong(request.getParameter("id"));
		  FeedbackDao dao = DaoFactory.getFeedbackDao();
		isDeleted= dao.delete_feedback(id);
		if(isDeleted){
			response.sendRedirect("view_feedback.jsp");
		}else{
			response.getWriter().print("error in deletion");
		}
	}
	}

