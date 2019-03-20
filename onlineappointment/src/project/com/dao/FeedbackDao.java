package project.com.dao;

import java.util.List;

import project.com.bo.Feedback;
import project.com.bo.Patient;

public interface FeedbackDao {
	public abstract Long get_id();
	public abstract boolean post_feedback(Feedback feedback);
	public abstract List<Feedback> get_all_feedback();
	public abstract List<Feedback> get_available_feedback();
	public abstract boolean make_available(Long id);
	public abstract boolean delete_feedback(Long id);
}
