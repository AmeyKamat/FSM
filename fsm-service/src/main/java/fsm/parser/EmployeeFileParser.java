package fsm.parser;

import fsm.model.domain.Employee;

import java.io.File;
import java.util.Map;

public interface EmployeeFileParser {

    public Map<String, Employee> parseEmployee(File file);

}
