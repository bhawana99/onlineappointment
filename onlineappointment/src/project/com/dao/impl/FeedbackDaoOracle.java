package project.com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.Feedback;
import project.com.dao.FeedbackDao;
import sis.com.util.db.DBConnectionUtil;

public class FeedbackDaoOracle implements FeedbackDao {

	public Long get_id(){

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        Long id = 0L;
        
        try {
			con = DBConnectionUtil.getConnection();
			String sql = "select nvl(max(f_id),0)+1 from feedback_table";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				id = rs.getLong(1);
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
		return id;
	}
	
	
	public boolean post_feedback(Feedback feedback) {
		
		long id = feedback.getId();
		String name = feedback.getName();
		String email = feedback.getName();
		String review = feedback.getReview();
		Date date = feedback.getDof();
		String isAvailable = feedback.getIsAvailable();
		
		Connection con = null;
		PreparedStatement pstmt = null;
        boolean isAdded = false;
        
        try {
			con = DBConnectionUtil.getConnection();
			String sql = "insert into feedback_table values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, review);
			pstmt.setDate(5, date);
			pstmt.setString(6, isAvailable);
			
			
			if(pstmt.executeUpdate()>0)
				isAdded = true;

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return isAdded;
	}
	
	
	public List<Feedback> get_all_feedback() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<Feedback> list = new ArrayList<Feedback>();
				
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select * from feedback_table where available=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "false");
			rs  = pstmt.executeQuery();
			
			while(rs.next()){
				Feedback feedback = new Feedback();
				Long id = rs.getLong("f_id");
				String name = rs.getString("user_name");
				String email = rs.getString("email");
				String review = rs.getString("review_text");
				Date date = rs.getDate("dof");
				String isAvailable = rs.getString("available");
				
				feedback.setId(id);
				feedback.setName(name);
				feedback.setEmail(email);
				feedback.setReview(review);
				feedback.setDof(date);
				feedback.setIsAvailable(isAvailable);
				
				list.add(feedback);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return list;
	}

	public List<Feedback> get_available_feedback() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<Feedback> list = new ArrayList<Feedback>();
				
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select * from feedback_table where available=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "true");
			rs  = pstmt.executeQuery();
			
			while(rs.next()){
				Feedback feedback = new Feedback();
				Long id = rs.getLong("f_id");
				String name = rs.getString("user_name");
				String email = rs.getString("email");
				String review = rs.getString("review_text");
				Date date = rs.getDate("dof");
				String isAvailable = rs.getString("available");
				
				feedback.setId(id);
				feedback.setName(name);
				feedback.setEmail(email);
				feedback.setReview(review);
				feedback.setDof(date);
				feedback.setIsAvailable(isAvailable);
				
				list.add(feedback);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		return list;
	}

	public boolean make_available(Long id) {
		Connection con = null;
		PreparedStatement pstmt = null;
        boolean isUpdated = false;
        
        try {
			con = DBConnectionUtil.getConnection();
			String sql = "update feedback_table set available=? where f_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "true");
			pstmt.setLong(2, id);
						
			
			if(pstmt.executeUpdate()>0)
				isUpdated = true;

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return isUpdated;
	}

	
	public boolean delete_feedback(Long id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
        boolean isDeleted = false;
        
        try {
			con = DBConnectionUtil.getConnection();
			String sql = "delete from feedback_table where f_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, id);
						
			
			if(pstmt.executeUpdate()>0)
				isDeleted = true;

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DBConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return isDeleted;
	}

	

}
