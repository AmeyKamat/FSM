package fsm.service.impl;

import fsm.dao.EmployeeDao;
import fsm.model.domain.Employee;
import fsm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public Integer addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional
    public void removeEmployee(int employeeId) {
    	employeeDao.removeEmployee(employeeId);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
    	employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

}
