package fsm.service.impl;

import fsm.model.domain.Desk;
import fsm.model.domain.Employee;
import fsm.model.domain.Floor;
import fsm.model.domain.Table;
import fsm.parser.EmployeeFileParser;
import fsm.parser.LayoutFileParser;
import fsm.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
public class ParsingServiceImpl implements ParsingService{

    @Autowired
    LayoutFileParser layoutFileParser;
    @Autowired
    EmployeeFileParser employeeFileParser;

    @Override
    public Floor parseLayout(File file) {
        Floor floor = layoutFileParser.parseLayout(file);
        Map<String, Employee> deskEmployeeMap = employeeFileParser.parseEmployee(file);
        mapEmployeeToDesk(floor, deskEmployeeMap);
        return floor;
    }

    private void mapEmployeeToDesk(Floor floor, Map<String, Employee> deskEmployeeMap) {

        for (Table table: floor.getTables()) {
            for (Desk desk: table.getDesks()) {
                Employee employee = deskEmployeeMap.get(desk.getDeskCode());
                if (employee != null) {
                    desk.setDeskEmployee(employee);
                    employee.setDesk(desk);
                }
            }
        }

    }
}
