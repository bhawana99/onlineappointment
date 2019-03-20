import java.util.List;

import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;


public class view_all_appointment {

	public static void main(String[] args) {
		PatientDao dao = DaoFactory.getPatientDao();
		List<Patient> list = dao.view_all_appointment();
		
		System.out.println(list.size());
		for(int p=1;p<=list.size();p++){
			Patient patient = list.get(p-1);
			System.out.println(patient.getP_email());
			System.out.println(patient.getD_id());
			System.out.println(patient.getDept_id());
			System.out.println(patient.getDoa());
		}

	}

}
