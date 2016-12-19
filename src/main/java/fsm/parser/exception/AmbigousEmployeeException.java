package fsm.parser.exception;

public class AmbigousEmployeeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AmbigousEmployeeException(String message) {
        super(message);
    }

    public AmbigousEmployeeException(Throwable exception) {
        super(exception);
    }
}
