package project.com.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.swing.text.DefaultEditorKit.PasteAction;

import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.exception.InvalidAgeException;
import project.com.exception.InvalidContactException;
import project.com.exception.InvalidMailException;
import project.com.exception.PasswordLengthException;
import project.com.exception.PasswordMismatchException;
import sis.com.util.db.DBConnectionUtil;

public class PatientDaoOracle implements PatientDao {

	public Long generate_patient_id() {
		Long id = null;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DBConnectionUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select nvl(max(p_id),10000000)+1  from patient_appointment";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				id = rs.getLong(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return id;
	}

	public boolean patient_validate(Patient patient) throws Exception {

		String password = patient.getP_password();
		int age = patient.getP_age();
		String contact = patient.getP_contact();

		if (password.length() < 8) {
			String message = "password should be of atleast 8 character";
			throw new PasswordLengthException(message);
		}

		if (age < 1 || age > 120) {
			String message = "Invalid age";
			throw new InvalidAgeException(message);
		}

		if (contact.length() != 10) {
			String message = "contact no should be of length 10";
			throw new InvalidContactException(message);
		}

		return true;
	}

	public Patient login_validate(String id, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Patient patient = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select * from patient_details where p_email=? and p_password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				patient = new Patient();
				patient.setP_email(rs.getString("p_email"));
				patient.setP_fname(rs.getString("p_fname"));
				patient.setP_lname(rs.getString("p_lname"));
				patient.setP_password(rs.getString("p_password"));
				patient.setP_age(rs.getInt("p_age"));
				patient.setP_contact(rs.getString("p_contact"));
				patient.setP_gender(rs.getString("p_gender"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return patient;
	}

	public List<Patient> get_all_patient() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Patient> patientList = new ArrayList<Patient>();

		try {
			con = DBConnectionUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from patient_details";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Patient p = new Patient();

				p.setP_fname(rs.getString("p_fname"));
				p.setP_lname(rs.getString("p_lname"));
				p.setP_password(rs.getString("p_password"));
				p.setP_age(rs.getInt("p_age"));
				p.setP_email(rs.getString("p_email"));
				p.setP_contact(rs.getString("p_contact"));
				p.setP_gender(rs.getString("p_gender"));
				/*
				 * p.setP_id(rs.getLong("p_id"));
				 * p.setD_id(rs.getString("d_id")); p.setDoa(rs.getDate("doa"));
				 * p.setDept_id(rs.getString("dept_id"));
				 */

				patientList.add(p);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return patientList;
	}

	public boolean email_validation(String email) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select * from patient_details where p_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String message = "email already registered. Please login with existing ID ";
				throw new InvalidMailException(message);
			}

		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}

	public boolean add_patient(Patient patient) {

		String p_fname = patient.getP_fname();
		String p_lname = patient.getP_lname();
		String p_password = patient.getP_password();
		int p_age = patient.getP_age();
		String p_email = patient.getP_email();
		String p_contact = patient.getP_contact();
		String p_gender = patient.getP_gender();

		/*
		 * Long p_id = patient.getP_id(); String d_id = patient.getD_id(); Date
		 * dao = patient.getDoa(); String dept_id = patient.getDept_id();
		 */

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int isadded = 0;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = "insert into patient_details values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_email);
			pstmt.setString(2, p_fname);
			pstmt.setString(3, p_lname);
			pstmt.setString(4, p_password);
			pstmt.setInt(5, p_age);
			pstmt.setString(6, p_contact);
			pstmt.setString(7, p_gender);

			isadded = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		if (isadded > 0)
			return true;
		else
			return false;

	}

	public boolean fix_appointment(Patient patient) {

		String p_email = patient.getP_email();
		Long p_id = patient.getP_id();
		String d_id = patient.getD_id();
		Date doa = patient.getDoa();
		String dept_id = patient.getDept_id();
		String diagnosed = patient.getIsDiagnosed();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int isadded = 0;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = "insert into patient_appointment values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, p_id);
			pstmt.setString(2, p_email);
			pstmt.setString(3, d_id);
			pstmt.setDate(4, doa);
			pstmt.setString(5, dept_id);
			pstmt.setString(6, diagnosed);

			isadded = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		if (isadded > 0)
			return true;
		else
			return false;

	}

	public List<Patient> view_all_appointment(String id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Patient> list = new ArrayList<Patient>();

		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select d_id,doa,dept_id,diagnosed from patient_appointment where p_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Patient p = new Patient();
				p.setD_id(rs.getString(1));
				p.setDoa(rs.getDate(2));
				p.setDept_id(rs.getString(3));
				p.setIsDiagnosed(rs.getString(4));
				list.add(p);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}

	public List<Patient> view_all_appointment() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Patient> list = new ArrayList<Patient>();
        
		try {
			con = DBConnectionUtil.getConnection();
			//String sql = "select * from patient_appointment";
			String sql = "select p_id,p_fname,p_lname,p.p_email,dept_id,d_id,doa,diagnosed from patient_appointment a,patient_details p where p.p_email=a.p_email";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Patient p = new Patient();
				p.setP_id(rs.getLong(1));
				p.setP_fname(rs.getString(2));
				p.setP_lname(rs.getString(3));
				p.setP_email(rs.getString(4));
				p.setDept_id(rs.getString(5));
				p.setD_id(rs.getString(6));
				p.setDoa(rs.getDate(7));
				p.setIsDiagnosed(rs.getString(8));
				list.add(p);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}

	
	public boolean changePasswordValidate(String email,String oldPassword,String password1, String password2) throws Exception {
       Connection con = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
		
		try {
        	con = DBConnectionUtil.getConnection();
			String sql = "select * from patient_details where p_email=? and p_password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, oldPassword);
			rs = pstmt.executeQuery();

			if(!rs.next()) {
				String message = "Password doesn't match";
				throw new PasswordMismatchException(message);
			}
			
			if(!password1.equals(password2)){
				String message = "new password and confirm password should be same";
				throw new PasswordMismatchException(message);
			}
			
			if(password1.length()<8){
				String message = "password should be of atleast 8 character";
				throw new PasswordLengthException(message);
			}
			
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		return true;
	}

	
	public boolean changePassword(String email,String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		int isUpdated = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			
			//String sql = "update patient_details set p_password=? where p_email=?";
			 String sql="update patient_details set p_password=? where p_email=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
		    pstmt.setString(2, email);
		    
		    isUpdated = pstmt.executeUpdate();
		    
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		if(isUpdated>0)
			return true;
		else
            return false;
	}

	public String get_patient_email(String p_id) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(p_id);
		String p_email = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select p_email from patient_appointment where p_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				p_email = rs.getString(1);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return p_email;
	}

	public String get_patient_name(Long id) {
		// TODO Auto-generated method stub
		String patient_name="";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnectionUtil.getConnection();
			
			//String sql = "update patient_details set p_password=? where p_email=?";
            String sql = "select p_fname,p_lname from patient_details where p_email=(select p_email from patient_appointment where p_id = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
		    
            rs = pstmt.executeQuery();
            
            if(rs.next()){
            	String p_fname = rs.getString(1);
            	String p_lname = rs.getString(2);
                patient_name = patient_name + p_fname +" "+ p_lname;
                
            }
            
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return patient_name;
	}

}
