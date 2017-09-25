package domain;

class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException() {
        super("Invalid Expression");
    }
}
