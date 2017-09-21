package domain;

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
        if ( !s.isEmpty ( ) ) {
            if ( s.equals (ADD_OPERATOR.getSymbol ( )) )
                return ADD_OPERATOR;
            if ( s.equals (SUBTRACT_OPERATOR.getSymbol ( )) )
                return SUBTRACT_OPERATOR;
            if ( s.equals (MULTIPLICATION_OPERATOR.getSymbol ( )) )
                return MULTIPLICATION_OPERATOR;
            if ( s.equals (DIVIDE_OPERATION.getSymbol ( )) )
                return DIVIDE_OPERATION;
        }
        throw new NoOperationException ( );
    }
}