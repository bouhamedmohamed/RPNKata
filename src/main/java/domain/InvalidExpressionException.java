package domain;

public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException() {
        super("Invalid Expression");
    }
}
