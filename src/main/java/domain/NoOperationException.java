package domain;

public class NoOperationException extends RuntimeException {
    public NoOperationException() {
        super("No operation match");
    }
}
