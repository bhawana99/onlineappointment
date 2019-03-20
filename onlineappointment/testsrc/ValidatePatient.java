import java.sql.Date;

import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;


public class ValidatePatient {
	public static void main(String[] args) {
		Patient patient = new Patient();
		PatientDao dao = DaoFactory.getPatientDao();
		
		patient.setP_id(dao.generate_patient_id());
		patient.setDept_id("d1");
		patient.setDoa(new java.sql.Date(new java.util.Date().getTime()));
		patient.setP_age(25);
		patient.setP_contact("8516802848");
		patient.setP_email("sjain@gmail.com");
        patient.setP_fname("bhawana");
        patient.setP_lname("sahu");
        patient.setP_gender("f");
        patient.setP_password("bhgsgddh");
        patient.setD_id("doc1");
        
        boolean isValid = true;
       /* try {
			isValid = dao.patient_validate(patient);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			isValid = false;
		}*/
        
        try {
			isValid = dao.email_validation(patient.getP_email());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			isValid = false;
		}
        
        if(isValid){
        	System.out.println("patient is valid");
        }else{
        	System.out.println("patient is not valid");
        }
	}
     
}
