package project.com.dao;

import java.util.List;

import project.com.bo.Admin;
import project.com.bo.Report;

public interface AdminDao {
	public abstract Admin login_admin(String email,String password);
}
