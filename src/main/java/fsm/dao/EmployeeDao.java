package fsm.dao;

import java.util.List;

import fsm.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao {
	
	public Integer addEmployee(Employee employee);

	public void removeEmployee(int employeeId);

	public void updateEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getAllEmployees();
	
}
