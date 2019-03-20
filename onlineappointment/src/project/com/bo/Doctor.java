package project.com.bo;

public class Doctor {
	private String d_id;
	private String d_name;
	private String dept_id;
	private String d_email;
	private String d_password;
	private String d_contact;

	public Doctor() {
		super();
	}
	

	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getD_email() {
		return d_email;
	}
	public void setD_email(String d_email) {
		this.d_email = d_email;
	}
	public String getD_password() {
		return d_password;
	}
	public void setD_password(String d_password) {
		this.d_password = d_password;
	}
	public String getD_contact() {
		return d_contact;
	}
	public void setD_contact(String d_contact) {
		this.d_contact = d_contact;
	}

	@Override
	public String toString() {
		return "Doctor [d_id=" + d_id + ", d_name=" + d_name + ", dept_id="
				+ dept_id + ", d_email=" + d_email + ", d_password="
				+ d_password + ", d_contact=" + d_contact + "]";
	}

}
