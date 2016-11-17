package fsm.service.impl;

import fsm.dao.EmployeeDao;
import fsm.domain.Employee;
import fsm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Transactional
	public Integer addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}

	@Transactional
	public void removeEmployee(int employeeId) {
	dao.removeEmployee(employeeId);
	}

	@Transactional
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}

	@Transactional
	public Employee getEmployeeById(int employeeId) {
		return dao.getEmployeeById(employeeId);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		return getAllEmployees();
	}

}
