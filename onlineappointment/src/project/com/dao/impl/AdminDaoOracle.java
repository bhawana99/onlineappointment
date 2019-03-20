package project.com.dao.impl;
import project.com.dao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.Admin;
import project.com.bo.Department;
import project.com.dao.*;
import sis.com.util.db.DBConnectionUtil;

public class AdminDaoOracle implements AdminDao{

	public Admin login_admin(String email, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "select * from admin where admin_email=? and admin_password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				admin = new Admin();
				admin.setAdmin_id(rs.getLong(1));
				admin.setAdmin_email(rs.getString(2));
				admin.setAdmin_password(rs.getString(3));
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

		return admin;
	}
}
