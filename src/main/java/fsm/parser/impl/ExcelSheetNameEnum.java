package fsm.parser.impl;

public enum  ExcelSheetNameEnum {

    FLOOR_PLAN_SHEET(0),
    EMPLOYEE_DESK_MAP_SHEET(1);

    private final int sheetNumber;

    private ExcelSheetNameEnum(int sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public int getSheetNumber() {
        return this.sheetNumber;
    }

}
