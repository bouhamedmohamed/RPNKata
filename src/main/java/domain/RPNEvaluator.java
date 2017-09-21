package domain;

public class RPNEvaluator {

    public static final String ADD_OPERATOR = "+";
    public static final String SUBTRACT_OPERATOR = "-";
    public static final String MULTIPLICATION_OPERATOR = "*";
    public static final String DIVIDE_OPERATION = "/";

    public String findOperation(String s) {
        if ( !s.isEmpty ( ) ) {
            if ( s.equals (ADD_OPERATOR) )
                return ADD_OPERATOR;
            if ( s.equals (SUBTRACT_OPERATOR) )
                return SUBTRACT_OPERATOR;
            if ( s.equals (MULTIPLICATION_OPERATOR) )
                return MULTIPLICATION_OPERATOR;
            if ( s.equals (DIVIDE_OPERATION) )
                return DIVIDE_OPERATION;
        }
        throw new NoOperationException ( );
    }
}
