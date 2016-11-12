package fsm.dao;

import java.util.List;

import fsm.domain.Employee;

public interface EmployeeDao {
	
	public void add(Employee employee);

	public void remove(int id);

	public void update(Employee employee);

	public void get(int id);

	public List<Employee> getAll();
	
}
