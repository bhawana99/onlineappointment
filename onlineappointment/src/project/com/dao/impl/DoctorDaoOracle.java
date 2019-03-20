package project.com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.Doctor;
import project.com.bo.Patient;
import project.com.bo.Report;
import project.com.dao.DoctorDao;
import sis.com.util.db.DBConnectionUtil;

public class DoctorDaoOracle implements DoctorDao {


	public Doctor getByName(String name) {
		Doctor doc  = null;
		Connection con  = null;
		PreparedStatement pstmt  =null;
		ResultSet rs = null;

		try {
			con  = DBConnectionUtil.getConnection();
			String sql = "select d_id,dept_id from doctor where d_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String id = rs.getString(1);
				String deptId = rs.getString(2);
				doc = new Doctor();
				doc.setD_id(id);
				doc.setDept_id(deptId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doc;
	}
	
	public List<Doctor> getById(String dept_id) {
		List<Doctor> doctor_list = new ArrayList<Doctor>();
		Connection con  = null;
		PreparedStatement pstmt  =null;
		ResultSet rs = null;

		try {
			con  = DBConnectionUtil.getConnection();
			String sql = "select d_id,dept_id from doctor where dept_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dept_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String d_id = rs.getString(1);
				String deptId = rs.getString(2);
				Doctor doc = new Doctor();
				doc.setD_id(d_id);
				doc.setDept_id(deptId);
				doctor_list.add(doc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doctor_list;
	}


	
	public List<Doctor> getAll() {
		List<Doctor> docList  = new ArrayList<Doctor>();

		Connection con  = null;
		Statement stmt  =null;
		ResultSet rs = null;
		try {
			con  = DBConnectionUtil.getConnection();
			stmt= con.createStatement();
			rs  =stmt.executeQuery("select * from doctor");
			while(rs.next()) {
				String id  = rs.getString("d_id");
				String deptId = rs.getString("dept_id");
				String contact = rs.getString("d_contact");
				String email = rs.getString("d_email");
				String password = rs.getString("d_password");
				String name = rs.getString("d_name");

				Doctor doc = new Doctor();
				doc.setD_contact(contact);
				doc.setD_email(email);
				doc.setD_id(id);
				doc.setD_name(name);
				doc.setD_password(password);
				doc.setDept_id(deptId);

				docList.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return docList;

	}

	
	public boolean add(Doctor doc) {
		boolean isAdded=false;
		Connection con  = null;
		PreparedStatement  pstmt  =null;
		try {
			con  = DBConnectionUtil.getConnection();
			String sql  ="insert into  doctor (d_id,d_name,dept_id,d_email,d_password,d_contact) values(?,?,?,?,?,?)";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, doc.getD_id());
			pstmt.setString(2, doc.getD_name());
			pstmt.setString(3, doc.getDept_id());
			pstmt.setString(4, doc.getD_email());
			pstmt.setString(5, doc.getD_password());
			pstmt.setString(6, doc.getD_contact());

			if(pstmt.executeUpdate()==1) {
				isAdded=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isAdded;
	}

	
	public boolean delete(String id) {
		boolean isDeleted=false;
		Connection con  = null;
		PreparedStatement  pstmt  =null;
		try {
			con  = DBConnectionUtil.getConnection();
			String sql  ="delete from  doctor  where d_id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			if(pstmt.executeUpdate()==1) {
				isDeleted=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isDeleted;

	}

	public boolean update(Doctor doc) {
		boolean isUpdated=false;


		Connection con  = null;
		PreparedStatement  pstmt  =null;
		try {
			con  = DBConnectionUtil.getConnection();
			String sql  ="update doctor set d_name=?,dept_id=?,d_email=?,d_contact=?,d_password=? where d_id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, doc.getD_name());
			pstmt.setString(2,doc.getDept_id());
			pstmt.setString(3, doc.getD_email());
			pstmt.setString(4, doc.getD_contact());
			pstmt.setString(5, doc.getD_password());
			pstmt.setString(6, doc.getD_id());

			if(pstmt.executeUpdate()==1) {
				isUpdated=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isUpdated;

	}

	
	public Doctor validLogin(String loginId, String loginPassword) {
		Doctor doctor = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = DBConnectionUtil.getConnection();
			String sql = "select d_id,d_name,dept_id,d_email,d_contact from doctor where d_email=? and d_password=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPassword);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String id = rs.getString("d_id");
				String name = rs.getString("d_name");
				String dept_id = rs.getString("dept_id");
				String email = rs.getString("d_email");
				String contact = rs.getString("d_contact");

				doctor = new Doctor();
				doctor.setD_contact(contact);
				doctor.setD_email(email);
				doctor.setD_id(id);
				doctor.setD_name(name);
				doctor.setDept_id(dept_id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doctor;
	}

	
	public List<Patient> getByDoctor(String doctorId) {
		List<Patient> patientList = new ArrayList<Patient>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = DBConnectionUtil.getConnection();
			String sql = "select p.p_fname, p.p_lname,p.p_contact,p.p_age,p.p_gender,a.doa, a.p_id, a.diagnosed ,p.p_email from patient_details p left join patient_appointment a on a.p_email = p.p_email where a.d_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, doctorId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String p_email = rs.getString("p_email");
				String p_fname = rs.getString("p_fname");
				String p_lname = rs.getString("p_lname");
				int p_age = (int)rs.getLong("p_age");
				String p_contact = rs.getString("p_contact");
				String p_gender = rs.getString("p_gender");
				Date p_doa = rs.getDate("doa");
				Long p_id = rs.getLong("p_id");
				String p_diagnosed = rs.getString("diagnosed");
				Patient patient = new Patient();
				patient.setP_fname(p_fname);
				patient.setP_lname(p_lname);
				patient.setP_email(p_email);
				patient.setP_age(p_age);
				patient.setIsDiagnosed(p_diagnosed);
				patient.setP_gender(p_gender);
				patient.setP_contact(p_contact);
				patient.setDoa(p_doa);
				patient.setP_id(p_id);

				patientList.add(patient);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return patientList;
	}

	
	public List<Patient> getTodayAppointment(Date doa) {
		List<Patient> patientlist = new ArrayList<Patient>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = DBConnectionUtil.getConnection();
			String sql = "select p.p_fname, p.p_lname,p.p_contact,p.p_age,p.p_gender,a.doa, a.p_id, a.diagnosed ,p.p_email from patient_details p left join patient_appointment a on a.p_email = p.p_email where a.doa = ?";
            
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return patientlist;
	}


	public List<String> getByDepartment(String department) {
		// TODO Auto-generated method stub
		List<String> doctorlist = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select d_name from doctor where dept_id=(select dept_id from department where dept_name=?)";
		    pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, department);
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()){
		    	String doctor_name = rs.getString(1);
		    	doctorlist.add(doctor_name);
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
		
		return doctorlist;
	}

	public String getDoctorName(String d_id) {
		// TODO Auto-generated method stub
		String doctor_name =null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select d_name from doctor where d_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				doctor_name = rs.getString(1);
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
		
		return doctor_name;
	}

	public List<Report> getReport(String doc_id) {
		List<Report> reportList = new ArrayList<Report>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select report_id,p_id from report where d_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, doc_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Long r_id = rs.getLong("report_id");
				Long p_id = rs.getLong("p_id");
				Report report = new Report();
				report.setR_id(r_id);
				report.setP_id(p_id);
				reportList.add(report);
			}
		    
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return reportList;
	}
	
	public List<Patient> getTodayAppointment() {
		List<Patient> patientList = new ArrayList<Patient>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pattern = "dd-MMM-yyyy";
		java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	    
		try{
			con = DBConnectionUtil.getConnection();
			String sql = "select p.p_fname, p.p_lname,p.p_contact,p.p_age,p.p_gender,a.doa, a.p_id, a.diagnosed ,p.p_email from patient_details p left join patient_appointment a on a.p_email = p.p_email where a.doa = ?";
		    pstmt = con.prepareStatement(sql);
		    pstmt.setDate(1, sqlDate);
		    rs = pstmt.executeQuery();
		    while(rs.next()){
		    	String p_email = rs.getString("p_email");
				String p_fname = rs.getString("p_fname");
				String p_lname = rs.getString("p_lname");
				int p_age = (int)rs.getLong("p_age");
				String p_contact = rs.getString("p_contact");
				String p_gender = rs.getString("p_gender");
				java.sql.Date p_doa = rs.getDate("doa");
				Long p_id = rs.getLong("p_id");
				String p_diagnosed = rs.getString("diagnosed");
				Patient patient = new Patient();
				patient.setP_fname(p_fname);
				patient.setP_lname(p_lname);
				patient.setP_email(p_email);
				patient.setP_age(p_age);
				patient.setIsDiagnosed(p_diagnosed);
				patient.setP_gender(p_gender);
				patient.setP_contact(p_contact);
				patient.setDoa(p_doa);
				patient.setP_id(p_id);

				patientList.add(patient);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return patientList;
	}



}
