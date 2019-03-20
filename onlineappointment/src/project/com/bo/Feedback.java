package project.com.bo;

import java.sql.Date;

public class Feedback {
     
	Long id;
	String name;
	String email;
	String review;
	Date dof;
    String isAvailable;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getDof() {
		return dof;
	}
	public void setDof(Date dof) {
		this.dof = dof;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", email=" + email
				+ ", review=" + review
				+ ", isAvalaible=" + isAvailable + "]";
	}
	
	
	
}
