package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.UserDao;
import fsm.domain.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(User user) {

		Session session = sessionFactory.getCurrentSession();
		Integer userID = (Integer) session.save(user);
		return userID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		User user = get(id);

		if (user != null) {
			session.delete(user);
		}

	}

	public void update(User user) {

		Session session = sessionFactory.getCurrentSession();
		session.update(user);

	}

	public User get(int id) {

		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;

	}

	public List<User> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		return criteria.list();

	}

}
