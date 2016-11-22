package fsm.service.impl;

import fsm.dao.RoleDao;
import fsm.domain.Role;
import fsm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    @Transactional
    public Integer addRole(Role role) {
        return dao.addRole(role);
    }

    @Transactional
    public void removeRole(int roleId) {
        dao.removeRole(roleId);
    }

    @Transactional
    public void updateRole(Role role) {
        dao.updateRole(role);
    }

    @Transactional
    public Role getRoleById(int roleId) {
        return dao.getRoleById(roleId);
    }

    @Transactional
    public List<Role> getAllRoles() {
        return dao.getAllRoles();
    }

}
