import java.util.List;


import project.com.bo.Patient;
import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;


public class GetAllPatient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatientDao dao = DaoFactory.getPatientDao();
		List<Patient> list = dao.get_all_patient();
		
		System.out.println(list.size());
		for(int p=1;p<=list.size();p++){
			Patient patient = list.get(p-1);
			System.out.println(patient.toString());
		}

	}

}
