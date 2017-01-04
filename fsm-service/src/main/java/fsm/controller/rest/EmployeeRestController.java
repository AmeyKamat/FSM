package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import fsm.model.domain.Employee;
import fsm.service.EmployeeService;
import fsm.util.JsonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/employee")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeById(@PathVariable("employeeId") int employeeId) throws JsonProcessingException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        String[] propsToBeIgnored = {};
        return JsonFilter.filter(employee, propsToBeIgnored);
    }
}
