package project.com.bo;

import java.sql.Date;

public class Patient {
    
	Long p_id;
    String p_fname;
    String p_lname;
    String p_password;
    int p_age;
    String p_email;
    String p_contact;
    String p_gender;
    String d_id;
    Date doa;
    String dept_id;
    String isDiagnosed;
    
	
	public Long getP_id() {
		return p_id;
	}
	
	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}
	
	public String getP_fname() {
		return p_fname;
	}
	public void setP_fname(String p_fname) {
		this.p_fname = p_fname;
	}
	public String getP_lname() {
		return p_lname;
	}
	public void setP_lname(String p_lname) {
		this.p_lname = p_lname;
	}
	public String getP_password() {
		return p_password;
	}
	public void setP_password(String p_password) {
		this.p_password = p_password;
	}
	public int getP_age() {
		return p_age;
	}
	public void setP_age(int p_age) {
		this.p_age = p_age;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public String getP_contact() {
		return p_contact;
	}
	public void setP_contact(String p_contact) {
		this.p_contact = p_contact;
	}
	public String getP_gender() {
		return p_gender;
	}
	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public Date getDoa() {
		return doa;
	}
	public void setDoa(Date doa) {
		this.doa = doa;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getIsDiagnosed() {
		return isDiagnosed;
	}

	public void setIsDiagnosed(String isDiagnosed) {
		this.isDiagnosed = isDiagnosed;
	}

	@Override
	public String toString() {
		return "Patient [p_id=" + p_id + ", p_fname=" + p_fname + ", p_lname="
				+ p_lname + ", p_password=" + p_password + ", p_age=" + p_age
				+ ", p_email=" + p_email + ", p_contact=" + p_contact
				+ ", p_gender=" + p_gender + ", d_id=" + d_id + ", doa=" + doa
				+ ", dept_id=" + dept_id + ", isDiagnosed=" + isDiagnosed + "]";
	}
    
	    
}
