package fsm.dao;

import fsm.model.domain.Employee;

import java.util.List;

public interface EmployeeDao {
	
	public Integer addEmployee(Employee employee);

	public void removeEmployee(int employeeId);

	public void updateEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public Employee getEmployeeByBrid(String brid);

	public List<Employee> getAllEmployees();
	
}
