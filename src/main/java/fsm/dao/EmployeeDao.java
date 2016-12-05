package fsm.dao;

import java.util.List;

import fsm.model.domain.Employee;

public interface EmployeeDao {
	
	public Integer addEmployee(Employee employee);

	public void removeEmployee(int employeeId);

	public void updateEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getAllEmployees();
	
}
