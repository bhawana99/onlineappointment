package project.com.controller;
import sis.com.util.db.DBConnectionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportDownloadController
 */
public class ReportDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportDownloadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id  = Long.parseLong(request.getParameter("id"));
		ServletOutputStream sos  = null;//to send to browser
		InputStream repDataIS  =null;//db to read
		
		
		  //response.setContentType("APPLICATION/OCTET-STREAM"); 
		 // response.setHeader("Content-Disposition", "attachment; filename=\""+file.getName()+"\""); 
		 // response.setHeader("Content-Disposition", "attachment; filename=\""+System.currentTimeMillis()+"_"+file.getName()+"\""); 
		  
		Connection con = null;
		Statement stmt= null;
		ResultSet rs = null;
		
		
		try {
			con = DBConnectionUtil.getConnection();
			stmt  = con.createStatement();
			rs =stmt.executeQuery("select * from report where report_id="+id);
			if(rs.next()) {
					String fileName = rs.getString("file_name");
					repDataIS  = rs.getBinaryStream("file_data");
					
					 
					sos = response.getOutputStream();
					response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
					
					byte[]buff = new byte[1024];
					int length;
					while(  (length=repDataIS.read(buff))!=-1) {
						sos.write(buff, 0, length);
					}//read write data to browser
			}//if rs.next()
			
		} catch (Exception e) {
		    e.printStackTrace();
		}finally {
			
			try {
				sos.close();
				DBConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		
		
		
	}

	


}
