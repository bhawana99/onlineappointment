package project.com.dao;
import java.util.List;

import project.com.bo.Doctor;
import project.com.bo.Patient;
import project.com.bo.Report;

public interface DoctorDao{
	public abstract	List<Doctor>  getAll();
	public abstract	List<Doctor>  getById(String dept_id);
	public abstract	Doctor  getByName(String name);
	public abstract String getDoctorName(String d_id);
	public abstract	List<String>  getByDepartment(String department);
	public abstract	boolean add(Doctor doc);
	public abstract	boolean delete(String id);
	public abstract boolean update(Doctor doc);
	public abstract Doctor validLogin(String logingId,String loginPassword);
    public abstract List<Patient> getByDoctor(String doctorId);
    public abstract List<Patient> getTodayAppointment(java.sql.Date doa);
	public abstract List<Report> getReport(String doc_id);
	public abstract List<Patient> getTodayAppointment();
}
