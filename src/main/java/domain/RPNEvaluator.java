package domain;

public class RPNEvaluator {
    public String findOperation(String s) {
        if ( s.isEmpty ( ) )
            throw new NoOperationException ( );
        if ( s.equals ("+") )
            return "+";
        else
            return "-";
    }
}
