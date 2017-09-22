package domain;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum RPNOperator {
    ADD_OPERATOR ("+", (a, b) -> add (a, b)),
    SUBTRACT_OPERATOR ("-", (a, b) -> sub (a, b)),
    MULTIPLICATION_OPERATOR ("*", (a, b) -> multiple (a, b)),
    DIVIDE_OPERATION ("/", (a, b) -> divided (a, b));
    private String symbol;
    private DoubleBinaryOperator operation;

    public String getSymbol() {
        return symbol;
    }

    RPNOperator(String symbol, DoubleBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static RPNOperator findOperation(String s) {
        return Arrays.stream (values ( ))
                .filter (rpnOperator -> rpnOperator.getSymbol ( ).equals (s))
                .findFirst ( )
                .orElseThrow (NoOperationException::new);
    }

    public static double add(double operandOne, double operandTwo) {
        return operandOne + operandTwo;
    }

    public static double sub(double operandOne, double operandTwo) {
        return operandOne - operandTwo;
    }


    public static double multiple(double operandOne, double operandTwo) {
        return operandOne * operandTwo;
    }

    public static double divided(double operandOne, double operandTwo) {
        if ( operandTwo == 0 )
            throw new IllegalArgumentException ("You can't divide by 0");
        return operandOne / operandTwo;
    }
}