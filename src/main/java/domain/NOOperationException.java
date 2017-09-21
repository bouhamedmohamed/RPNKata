package domain;

public class NOOperationException extends RuntimeException {
    public NOOperationException() {
        super("No operation match");
    }
}
