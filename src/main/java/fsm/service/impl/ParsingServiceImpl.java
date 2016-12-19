package fsm.service.impl;

import fsm.model.domain.Desk;
import fsm.model.domain.Floor;
import fsm.model.domain.Table;
import fsm.parser.EmployeeLocationFileParser;
import fsm.parser.LayoutFileParser;
import fsm.parser.impl.EmployeeLocationExcelParser;
import fsm.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ParsingServiceImpl implements ParsingService{

    @Autowired
    LayoutFileParser layoutFileParser;
    @Autowired
    EmployeeLocationFileParser employeeLocationFileParser;

    @Override
    public Floor parseLayout(File file) {
        Floor floor = layoutFileParser.parseLayout(file);
        employeeLocationFileParser.parseEmployeeLocation(file, floor);

        System.out.println("Printing parsed floor");
        for (Table table: floor.getTables()) {
            for (Desk desk: table.getDesks()) {
                System.out.println("Desk code: " + desk.getDeskCode() + ", Employee: " + desk.getDeskEmployee().getName());
            }
        }

        return floor;
    }
}
