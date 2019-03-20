package project.com.dao.factory;

import project.com.dao.AdminDao;
import project.com.dao.DepartmentDao;
import project.com.dao.DoctorDao;
import project.com.dao.FeedbackDao;
import project.com.dao.PatientDao;
import project.com.dao.ReportDao;
import project.com.dao.impl.AdminDaoOracle;
import project.com.dao.impl.DepartmentDaoOracle;
import project.com.dao.impl.DoctorDaoOracle;
import project.com.dao.impl.FeedbackDaoOracle;
import project.com.dao.impl.PatientDaoOracle;
import project.com.dao.impl.ReportDaoOracle;

public final class DaoFactory {
     private DaoFactory(){
    	 
     }
     
    private static PatientDao patientDao = null;
	public static PatientDao getPatientDao(){
		if(patientDao==null){
			patientDao = new PatientDaoOracle();
		}
		return patientDao;
	}
	
	private static FeedbackDao feedbackDao = null;
	public static FeedbackDao getFeedbackDao(){
		if(feedbackDao==null){
			feedbackDao = new FeedbackDaoOracle();
		}
		return feedbackDao;
	}
	
	private static DoctorDao doctorDao = null;
	public static DoctorDao getDoctorDao() {
		 if(doctorDao==null) {
			 doctorDao =new DoctorDaoOracle();
		 }
	 return doctorDao;
	}
	
    private static DepartmentDao departmentDao=null;
	public static DepartmentDao getDepartmentDao() {
		 if(departmentDao==null) {
			 departmentDao =new DepartmentDaoOracle();
		 }
	 return departmentDao;
	}
	
	public static ReportDao reportDao = null; 
	public static ReportDao getReportDao(){
		if(reportDao==null){
			reportDao = new ReportDaoOracle();
		}
		return reportDao;
	}
	
	public static AdminDao adminDao = null; 
	public static AdminDao getAdminDao(){
		if(adminDao==null){
			adminDao = new AdminDaoOracle();
		}
		return adminDao;
	}
	
}
