package fsm.parser.enums;

public enum ExcelSheetIdentity {

    FLOOR_PLAN_SHEET(0),
    EMPLOYEE_DESK_MAP_SHEET(1);

    private final int sheetNumber;

    private ExcelSheetIdentity(int sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public int getSheetNumber() {
        return this.sheetNumber;
    }

}
