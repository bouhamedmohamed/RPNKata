package domain;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum RPNOperator {
    ADD_OPERATOR ("+", (a, b) -> a + b),
    SUBTRACT_OPERATOR ("-", (a, b) -> a - b),
    MULTIPLICATION_OPERATOR ("*", (a, b) -> a * b),
    DIVIDE_OPERATION ("/", (a, b) -> {
        if ( b == 0 )
            throw new IllegalArgumentException ("You can't divide by 0");
        return a / b;
    });
    private final String symbol;
    private final DoubleBinaryOperator action;

    public String getSymbol() {
        return symbol;
    }

    RPNOperator(String symbol, DoubleBinaryOperator operation) {
        this.symbol = symbol;
        this.action = operation;
    }

    public static RPNOperator findOperation(String s) {
        return Arrays.stream (values ( ))
                .filter (rpnOperator -> rpnOperator.getSymbol ( ).equals (s))
                .findFirst ( )
                .orElseThrow (NoOperationException::new);
    }


    public RPNOperand calculate(RPNOperand operationOne, RPNOperand operationTwo) {
        return new RPNOperand (action.applyAsDouble (operationOne.getValue (), operationTwo.getValue ()));
    }
}