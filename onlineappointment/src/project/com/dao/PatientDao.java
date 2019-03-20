package project.com.dao;

import java.util.List;

import project.com.bo.Patient;

public interface PatientDao {
    public abstract Long generate_patient_id();
    //public abstract List<Report> get_reports();
    public abstract boolean patient_validate(Patient patient) throws Exception;
    public abstract boolean email_validation(String email) throws Exception;
    public abstract String  get_patient_email(String p_id);
    public abstract Patient login_validate(String id,String password);
    public abstract boolean add_patient(Patient patient);
    public abstract boolean fix_appointment(Patient patient);
    public abstract List<Patient> get_all_patient();
    public abstract List<Patient> view_all_appointment(String id);
    public abstract List<Patient> view_all_appointment();
    public abstract boolean changePasswordValidate(String email,String oldPassword,String password1,String password2) throws Exception;
    public abstract boolean changePassword(String email,String password);
	public abstract String get_patient_name(Long p_id);

}
