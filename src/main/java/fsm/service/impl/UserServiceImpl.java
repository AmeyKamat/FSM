package fsm.service.impl;

import fsm.dao.UserDao;
import fsm.model.domain.User;
import fsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Integer addUser(User user) {
        return userDao.addUser(user);

    }

    @Override
    @Transactional
    public void removeUser(int userId) {
    	userDao.removeUser(userId);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
    	userDao.updateUser(user);
    }

    @Override
    @Transactional
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    @Transactional
    public String checkLogin(String username, String password) {
        User user = getUserByUsername(username);
        if (user == null)
            return null;
        else if (user.getPassword().equals(password))
            return
                    "EQUAL";
        else
            return "NOTEQUAL";
    }

}
