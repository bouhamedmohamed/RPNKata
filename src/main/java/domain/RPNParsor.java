package domain;

public class RPNParsor {
    public String parse(String expression) {
        if ( expression.isEmpty ( ) )
            return "";
        else
            return "0";

    }
}
