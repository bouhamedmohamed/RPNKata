package domain;

public class RPNEvaluator {
    public String findOperation(String s) {
        if ( !s.isEmpty ( ) ) {
            if ( s.equals ("+") )
                return "+";
            if ( s.equals ("-") )
                return "-";
            if ( s.equals ("*") )
                return "*";
            if ( s.equals ("/") )
                return "/";
        }
        throw new NoOperationException ( );
    }
}
