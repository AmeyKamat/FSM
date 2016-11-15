package fsm.service.impl;

import fsm.dao.EmployeeDao;
import fsm.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeDao {

	@Autowired
	private EmployeeDao dao;

	public Integer addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}

	public void removeEmployee(int employeeId) {
	dao.removeEmployee(employeeId);
	}

	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}

	public Employee getEmployeeById(int employeeId) {
		return dao.getEmployeeById(employeeId);
	}

	public List<Employee> getAllEmployees() {
		return getAllEmployees();
	}

}
