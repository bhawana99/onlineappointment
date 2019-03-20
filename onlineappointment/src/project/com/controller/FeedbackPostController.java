package project.com.controller;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class FeedbackPostController
 */
public class FeedbackPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String review = request.getParameter("review");
		String isAvailable = "false";
		Date date = new java.sql.Date(new java.util.Date().getTime());

		FeedbackDao dao = DaoFactory.getFeedbackDao();
		Long id = dao.get_id();

		Feedback feedback = new Feedback();
		feedback.setId(id);
		feedback.setName(name);
		feedback.setEmail(email);
		feedback.setReview(review);
		feedback.setDof(date);
		feedback.setIsAvailable(isAvailable);

		boolean isAdded = dao.post_feedback(feedback);
		List<Feedback> feedbackList = dao.get_available_feedback();

		

		if (isAdded) {
			String message = "Thankyou for your Feedback";
			RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
			request.setAttribute("feedbacklist", feedbackList);
			request.setAttribute("message", message);
			rd.forward(request, response);
		} else {
			String message = "Error Ocuured! Try again";
			RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
			request.setAttribute("feedbacklist", feedbackList);
			request.setAttribute("message", message);
			rd.forward(request, response);
		}

	}

}
