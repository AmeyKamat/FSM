package fsm.dao.impl;

import java.util.List;

import fsm.domain.Location;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.UserDao;
import fsm.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		Integer userID = (Integer) session.save(user);
		return userID;

	}

	public void removeUser(int userId) {

		Session session = sessionFactory.getCurrentSession();
		User user = getUserById(userId);

		if (user != null) {
			session.delete(user);
		}

	}

	public void updateUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		session.update(user);

	}

	public User getUserById(int userId) {

		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, userId);
		return user;

	}

	public List<User> getAllUsers() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		return criteria.list();

	}

	@Override
	public User getUserByUsername(String username) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user=(User) criteria.uniqueResult();
		return user;
	}

}
