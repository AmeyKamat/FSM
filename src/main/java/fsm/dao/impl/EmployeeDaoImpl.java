package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.EmployeeDao;
import fsm.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Integer employeeID = (Integer) session.save(employee);
		return employeeID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		Employee employee = get(id);

		if (employee != null) {
			session.delete(employee);
		}

	}

	public void update(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		session.update(employee);

	}

	public Employee get(int id) {

		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;

	}

	public List<Employee> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		return criteria.list();

	}

}
