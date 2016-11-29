package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.EmployeeDao;
import fsm.model.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addEmployee(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Integer employeeID = (Integer) session.save(employee);
		return employeeID;

	}

	@Override
	public void removeEmployee(int employeeId) {

		Session session = sessionFactory.getCurrentSession();
		Employee employee = getEmployeeById(employeeId);

		if (employee != null) {
			session.delete(employee);
		}

	}

	@Override
	public void updateEmployee(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		session.update(employee);

	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		return employee;

	}

	@Override
	public List<Employee> getAllEmployees() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		return criteria.list();

	}

}
