package project.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Feedback;
import project.com.dao.FeedbackDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class ViewPostedFeedback
 */
public class ViewPostedFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FeedbackDao dao = DaoFactory.getFeedbackDao();
		List<Feedback> feedbackList = dao.get_available_feedback();
		
		if(feedbackList!=null){
			request.setAttribute("feedbacklist", feedbackList);
			RequestDispatcher rd = request.getRequestDispatcher("postedfeedback.jsp");
			rd.forward(request, response);
		}
	}

}
