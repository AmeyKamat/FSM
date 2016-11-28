package fsm.service;

import java.util.List;

import fsm.model.domain.Employee;

public interface EmployeeService {
	
	public Integer addEmployee(Employee employee);

	public void removeEmployee(int employeeId);

	public void updateEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getAllEmployees();
	
}
