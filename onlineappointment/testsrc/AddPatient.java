import java.util.List;

import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;


public class AddPatient {

	public static void main(String[] args) {
		
		Patient patient = new Patient();
		patient.setP_age(20);
		patient.setP_contact("8516802848");
		patient.setP_email("alex@gmail.com");
		patient.setP_fname("alex");
		patient.setP_gender("M");
		patient.setP_lname("pandian");
		patient.setP_password("12345678");
		
		PatientDao dao = DaoFactory.getPatientDao();
		boolean isAdded = dao.add_patient(patient);
		
		System.out.println(isAdded);
		
		List<Patient> list = dao.get_all_patient();
		
		for(int p=1;p<list.size();p++){
			Patient pat = list.get(p-1);
			System.out.println(pat);
		}
	}

}
