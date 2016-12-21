package fsm.parser.enums;

public enum ExcelEmployeeSheetColumnIdentity {

    DESK_CODE_COLUMN(0),
    BRID_COLUMN(1),
    EMPLOYEE_NAME_COLUMN(2);

    private final int columnNumber;

    private ExcelEmployeeSheetColumnIdentity(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

}
