package domain;

import java.util.Arrays;

public enum RPNOperator {
    ADD_OPERATOR ("+"), SUBTRACT_OPERATOR ("-"), MULTIPLICATION_OPERATOR ("*"), DIVIDE_OPERATION ("/");
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    RPNOperator(String symbol) {
        this.symbol = symbol;
    }

    public static RPNOperator findOperation(String s) {
        return Arrays.stream (values ( ))
                .filter (rpnOperator -> rpnOperator.getSymbol ( ).equals (s))
                .findFirst ( )
                .orElseThrow (NoOperationException::new);
    }

    public int add(int operandOne, int operandTwo) {
        return operandOne + operandTwo;
    }
}