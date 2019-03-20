package project.com.dao;
import java.util.List;
import project.com.bo.Department;
public interface DepartmentDao {
	public abstract	Department  getByName(String name);
	public abstract String getDepartmentName(String dept_id);
	public abstract Department getById(String id);
	public abstract	List<Department>  getAll();
	public abstract	boolean add(Department dept);
	public abstract	boolean update(Department dept);
	public abstract	boolean delete(String id);

}
