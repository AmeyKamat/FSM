package fsm.parser.impl;

import fsm.model.domain.Employee;
import fsm.parser.EmployeeFileParser;
import fsm.parser.exception.AmbigousEmployeeException;
import fsm.service.EmployeeService;
import fsm.util.ParsingResourceProvider;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeExcelParser implements EmployeeFileParser {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Map<String, Employee> parseEmployee(File file) {
        Workbook workbook = ParsingResourceProvider.getWorkbook(file);
        Sheet sheet = workbook.getSheet(ExcelSheetNameEnum.EMPLOYEE_DESK_MAP_SHEET.getSheetNumber());

        return this.parseDeskEmployeeInfo(sheet);
    }

    private Map<String, Employee> parseDeskEmployeeInfo(Sheet sheet) {
        Map<String, Employee> deskEmployeeMap = new HashMap<String, Employee>();

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

        return deskEmployeeMap;
    }

    private Employee getEmployee(String brid, String employeeName) {
        Employee employee = employeeService.getEmployeeByBrid(brid);
        if (employee != null) {
            if (!employee.getName().toUpperCase().equals(employeeName.toUpperCase())) {
                throw new AmbigousEmployeeException(brid, employee.getName(), employeeName);
            }
            else {
                return employee;
            }
        }
        else {
            return new Employee(brid, employeeName);
        }
    }

    private boolean isCellValidDeskEntry(Cell cell) {
        boolean validDesk = true;
        if (cell.getContents().isEmpty() || cell.getType() != CellType.NUMBER) {
            validDesk = false;
        }
        return validDesk;
    }

}
