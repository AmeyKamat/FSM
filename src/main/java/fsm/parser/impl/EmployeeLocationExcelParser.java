package fsm.parser.impl;

import fsm.model.domain.Desk;
import fsm.model.domain.Employee;
import fsm.model.domain.Floor;
import fsm.model.domain.Table;
import fsm.parser.EmployeeLocationFileParser;
import fsm.parser.exception.AmbigousEmployeeException;
import fsm.parser.exception.ParserException;
import fsm.service.EmployeeService;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rohit Singh on 19-12-2016.
 */
@Component
public class EmployeeLocationExcelParser implements EmployeeLocationFileParser {

    @Autowired
    private EmployeeService employeeService;
    private Map<String, Employee> deskEmployeeMap;

    public EmployeeLocationExcelParser() {
        this.deskEmployeeMap = new HashMap<String, Employee>();
    }

    @Override
    public void parseEmployeeLocation(File file, Floor floor) {
        Workbook workbook = this.getWorkbook(file);
        Sheet sheet = workbook.getSheet(1);

        this.parseDeskEmployeeInfo(sheet);
        this.mapEmployeeToDesk(floor);
    }

    private void parseDeskEmployeeInfo(Sheet sheet) {
        for (int row = 1; row < sheet.getRows(); row++) {
            Cell deskCodeCell = sheet.getCell(0, row);

            if (isCellValidDeskEntry(deskCodeCell)) {
                String deskCode = deskCodeCell.getContents();
                String brid = sheet.getCell(1, row).getContents();
                String employeeName = sheet.getCell(2, row).getContents();

                Employee employee = this.getEmployee(brid, employeeName);
                deskEmployeeMap.put(deskCode, employee);
            }
        }
    }

    private Employee getEmployee(String brid, String employeeName) {
        Employee employee = employeeService.getEmployeeByBrid(brid);
        if (employee != null) {
            if (!employee.getName().equals(employeeName)) {
                throw new AmbigousEmployeeException("An employee already exists with the brid: " + brid + ", name: "
                        + employee.getName() + ", rather than name: " + employeeName);
            }
            else {
                return employee;
            }
        }
        else {
            return new Employee(brid, employeeName);
        }
    }

    private void mapEmployeeToDesk(Floor floor) {

        for (Table table: floor.getTables()) {
            for (Desk desk: table.getDesks()) {
                desk.setDeskEmployee(deskEmployeeMap.get(desk.getDeskCode()));
            }
        }

    }

    private Workbook getWorkbook(File file) {
        Workbook workbook;
        try {
            workbook = Workbook.getWorkbook(file);
        } catch (BiffException be) {
            throw new ParserException(be);
        }
        catch (IOException ioe) {
            throw new ParserException(ioe);
        }
        return workbook;
    }

    private boolean isCellValidDeskEntry(Cell cell) {
        boolean validDesk = true;
        if (cell.getContents().isEmpty() || cell.getType() != CellType.NUMBER) {
            validDesk = false;
        }
        return validDesk;
    }

}
