package domain;

public class InvalidExpression extends RuntimeException {
    public InvalidExpression() {
        super("Invalid Expression");
    }
}
