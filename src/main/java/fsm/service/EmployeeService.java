package fsm.service;

import fsm.domain.Employee;

import java.util.List;

public interface EmployeeService {
	
	public Integer addEmployee(Employee employee);

	public void removeEmployee(int employeeId);

	public void updateEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getAllEmployees();
	
}
