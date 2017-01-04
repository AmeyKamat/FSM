package fsm.parser.exception;

public class AmbigousEmployeeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AmbigousEmployeeException(String brid, String existingEmployeeName, String newEnteredName) {
        super("An employee already exists with the brid: " + brid + ", name: "
                + existingEmployeeName + ", rather than name: " + newEnteredName);
    }

    public AmbigousEmployeeException(Throwable exception) {
        super(exception);
    }
}
