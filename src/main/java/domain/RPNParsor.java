package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RPNParsor {
    List<String> expressionList;
    private AtomicInteger indice;

    public RPNParsor(String expression) {
        this.expressionList = new ArrayList<> ( );
        if ( !expression.isEmpty ( ) )
            this.expressionList = createElements (expression);

        this.indice = new AtomicInteger (0);
    }

    private List createElements(String expression) {
        String[] expressionParsed = expression.split (" ");
        expressionList.addAll (Arrays.asList (expressionParsed));
        return expressionList;
    }


    public String getNext() {
        if ( expressionList.size ( ) > indice.get ( ) )
            return expressionList.get (indice.getAndIncrement ( ));
        return "";
    }


    public boolean isOperand(String currentElement) {

        for (int indice = 0; indice < currentElement.length ( ); indice++) {
            if ( !Character.toString (currentElement.charAt (indice)).matches ("[0-9]") )
                return false;
        }
        return true;
    }

    public boolean isValid() throws InvalidExpressionException {
        if ( operandCountIsDoubleOperatorCount ( ) )
            return true;
        throw new InvalidExpressionException ( );

    }

    private boolean operandCountIsDoubleOperatorCount() {
        if ( expressionList.isEmpty ( ) )
            return false;

        final long operandCount = expressionList.stream ( )
                .filter (element -> isOperand (element))
                .count ( );
        final int operatorCount = (int) (expressionList.size ( ) - operandCount);
        return ((operatorCount + 1) == operandCount) && (operatorCount != 0);
    }
}
