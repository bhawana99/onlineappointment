import project.com.bo.Patient;

import project.com.dao.PatientDao;
import project.com.dao.factory.DaoFactory;


public class LoginPatient {

	public static void main(String[] args) {
		
		PatientDao dao = DaoFactory.getPatientDao();
		Patient p = dao.login_validate("sjain@gmail.com", "sjain_207");
		
		//System.out.println(p);
		if(p!=null){
			System.out.println("successfully logged in");
		}else{
			System.out.println("Invalid user id/password");
		}
	}

}
