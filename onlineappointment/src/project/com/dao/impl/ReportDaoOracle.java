package project.com.dao.impl;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.Report;
import project.com.dao.ReportDao;
import sis.com.util.db.DBConnectionUtil;

public class ReportDaoOracle implements ReportDao{
	
   public void setInfo(Report r,Long p_id){
	   Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select d_id,p_email from patient_appointment where p_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,p_id);
			rs = pstmt.executeQuery();
				if(rs.next()){
					r.setD_id(rs.getString("d_id"));
					r.setP_email(rs.getString("p_email"));
				}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	   
   }
   
   public boolean delete(Long id){
	   
	   boolean isDeleted=false;
		 Connection con  = null;
		 PreparedStatement  pstmt  =null;
		 try {
			 con  = DBConnectionUtil.getConnection();
			 String sql  ="delete from  report  where report_id=?";
			 pstmt= con.prepareStatement(sql);
			 pstmt.setLong(1, id);
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
   
	public List<Report> getAllReport() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Report> list1 = new ArrayList<Report>();

		try {
			con = DBConnectionUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select report_id,p_id,d_id,file_name from report");
				while(rs.next()){
					Report r = new Report();
					r.setR_id(rs.getLong(1));
					r.setP_id(rs.getLong(2));
					r.setD_id(rs.getString(3));
					r.setFile_name(rs.getString(4));
					list1.add(r);
				}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list1;
	}

	public List<Report> getReportById(String id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Report> reportlist = new ArrayList<Report>();

		try {
			con = DBConnectionUtil.getConnection();
			/*String sql = " select report_id,d_id,file_name from report where p_id ="
					+ " (select p_id from patient_appointment where p_email="
					+ "(select p_email from patient_details where p_email=?))";
			*/
			
			String sql = "select report_id,d_id,file_name from report where p_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
				while(rs.next()){
					Report r = new Report();
					r.setR_id(rs.getLong(1));
					r.setD_id(rs.getString(2));
					r.setFile_name(rs.getString(3));
					reportlist.add(r);
				}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return reportlist;
	}

}
