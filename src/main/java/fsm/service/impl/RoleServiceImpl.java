package fsm.service.impl;

import fsm.dao.RoleDao;
import fsm.model.domain.Role;
import fsm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public Integer addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    @Transactional
    public void removeRole(int roleId) {
    	roleDao.removeRole(roleId);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
    	roleDao.updateRole(role);
    }

    @Override
    @Transactional
    public Role getRoleById(int roleId) {
        return roleDao.getRoleById(roleId);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

}
