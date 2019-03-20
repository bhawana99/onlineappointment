package project.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import project.com.bo.Doctor;
import project.com.bo.Patient;
import project.com.dao.DoctorDao;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;
import sis.com.util.db.DBConnectionUtil;

/**
 * Servlet implementation class UploadController
 */
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DoctorDao doctorDao = DaoFactory.getDoctorDao();
		PatientDao patientDao = DaoFactory.getPatientDao();

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {

			ServletFileUpload uploadUtil = null;
			uploadUtil = new ServletFileUpload(new DiskFileItemFactory());
			try {
				List<FileItem> fileItemList = uploadUtil.parseRequest(request);
				String fileName = null;
				InputStream fileData = null;

				FileItem fileItem = fileItemList.get(0);
				FileItem fileItem1 = fileItemList.get(1);
				FileItem fileItem2 = fileItemList.get(2);

				fileName = fileItem2.getName();
				fileData = fileItem2.getInputStream();
				int size = (int) fileItem2.getSize();

				String id = fileItem.getString().trim();
				Long p_id = Long.parseLong(id);
				String doctor_name = fileItem1.getString().trim();

				Doctor doctor = doctorDao.getByName(doctor_name);

				String patient_email = patientDao.get_patient_email(id);
				String d_id = doctor.getD_id();

				// file code or jdbc
				System.out.println(fileName);
				System.out.println(fileData);
				System.out.println(size);
				System.out.println(p_id);
				System.out.println(doctor_name);
				System.out.println(d_id);
				System.out.println(patient_email);

				Connection con = null;
				PreparedStatement pstmt = null;

				try {
					con = DBConnectionUtil.getConnection();
					String sql = "insert into report(report_id,p_id,d_id,p_email,file_name,file_data)"
							+ "values((select nvl(max(report_id),0)+1 from report),?,?,?,?,?)";

					pstmt = con.prepareStatement(sql);

					pstmt.setLong(1, p_id);
					pstmt.setString(2, d_id);
					pstmt.setString(3, patient_email);
					pstmt.setString(4, fileName);
					pstmt.setBinaryStream(5, fileData, size);

					int totalInsert = pstmt.executeUpdate();
					if (totalInsert == 1) {
						response.sendRedirect("recordlist");

					} else {
						response.getWriter().print(
								"no such patient id or doctor id exist");
						response.sendRedirect("upload.jsp");
					}

				} catch (Exception e) {
					response.getWriter().print(
							"no such patient id or department id exist");
				} finally {
					try {
						DBConnectionUtil.closeConnection(con);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}

		}// is multipart
	}

}
