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

    public int sub(int operandOne, int operandTwo) {
        return operandOne - operandTwo;
    }


    public int multiple(int operandOne, int operandTwo) {
        return operandOne * operandTwo;
    }

    public int divided(int operandOne, int operandTwo) {
        if ( operandTwo == 0 )
            throw new IllegalArgumentException ("You can't divide by 0");
        return operandOne / operandTwo;
    }
}