package project.com.dao.impl;
import project.com.dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.Department;
import project.com.dao.*;
import sis.com.util.db.DBConnectionUtil;
public class DepartmentDaoOracle implements DepartmentDao{

	
	public Department getByName(String name) {
		Department dept  = null;
		Connection con  = null;
		PreparedStatement pstmt  =null;
		ResultSet rs = null;
		
		try {
			con  = DBConnectionUtil.getConnection();
			String sql = "select * from department where lower(dept_name)=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name.toLowerCase());
			rs=pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("dept_id");
				dept = new Department();
				dept.setDept_id(id);
				dept.setDept_name(name);
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
		return dept;
	}

	
	public List<Department> getAll() {
		List<Department> deptList  = new ArrayList<Department>();

		Connection con  = null;
		Statement stmt  =null;
		ResultSet rs = null;
		try {
			con  = DBConnectionUtil.getConnection();
			stmt= con.createStatement();
			rs  =stmt.executeQuery("select * from department");
			while(rs.next()) {
				String id  = rs.getString("dept_id");
				String name = rs.getString("dept_name");
                String diseases = rs.getString("diseases");
                
				Department dept = new Department();
				dept.setDept_id(id);
				dept.setDept_name(name);
                dept.setDiseases(diseases);
                
				deptList.add(dept);
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

		return deptList;
	}

	
	public boolean add(Department dept) {
		boolean isAdded=false;
		Connection con  = null;
		PreparedStatement  pstmt  =null;
		ResultSet rs = null;
		try {
			con  = DBConnectionUtil.getConnection();
			String sql  ="insert into  department values(?,?,?)";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, dept.getDept_id());
			pstmt.setString(2, dept.getDept_name());
			pstmt.setString(3, dept.getDiseases());

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

	public boolean update(Department dept) {
		
		boolean isUpdated=false;
		Connection con  = null;
		PreparedStatement  pstmt  =null;
		ResultSet rs = null;
		try {
			con  = DBConnectionUtil.getConnection();
			String sql  ="update department set dept_name=?,diseases=? where dept_id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, dept.getDept_name());
			pstmt.setString(2, dept.getDiseases());
			pstmt.setString(3, dept.getDept_id());

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

	
	public boolean delete(String id) {
		boolean isDeleted=false;
		 Connection con  = null;
		 PreparedStatement  pstmt  =null;
		 try {
			 con  = DBConnectionUtil.getConnection();
			 String sql  ="delete from  department  where dept_id=?";
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


	public String getDepartmentName(String dept_id) {
		// TODO Auto-generated method stub
        String dept_name =null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select dept_name from department where dept_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dept_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dept_name = rs.getString(1);
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
		
		return dept_name;
	}


	public Department getById(String id) {
		// TODO Auto-generated method stub
		Department dept  = null;
		Connection con  = null;
		PreparedStatement pstmt  =null;
		ResultSet rs = null;
		
		try {
			con  = DBConnectionUtil.getConnection();
			String sql = "select * from department where dept_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String d_id = rs.getString(1);
				String name = rs.getString(2);
				String diseases = rs.getString(3);
				
				dept = new Department();
				dept.setDept_id(d_id);
				dept.setDept_name(name);
				dept.setDiseases(diseases);
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
		return dept;
		
	}
}
