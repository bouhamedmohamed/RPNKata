package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class RPNParser {
    private List<String> expressionList;
    @SuppressWarnings("CanBeFinal")
    private AtomicInteger position;

    public RPNParser(String expression) {
        this.expressionList = new ArrayList<> ( );
        if ( !expression.isEmpty ( ) )
            this.expressionList = createElements (expression);

        this.position = new AtomicInteger (0);
    }

    private List createElements(String expression) {
        String[] expressionParsed = expression.split (" ");
        expressionList.addAll (Arrays.asList (expressionParsed));
        return expressionList;
    }


    public String getNext() {
        if ( expressionList.size ( ) > position.get ( ) )
            return expressionList.get (position.getAndIncrement ( ));
        return "";
    }


    public boolean isOperand(String currentElement) {
        if ( currentElement.matches ("[0-9]+") )
            return true;
        return false;
    }

    @SuppressWarnings("SameReturnValue")
    public boolean isValid() throws InvalidExpressionException {
        if ( isValidExpression ( ) )
            return true;
        throw new InvalidExpressionException ( );
    }

    private boolean isValidExpression() {
        if ( expressionList.isEmpty ( ) )
            return false;

        final long operandCount = expressionList.stream ( )
                .filter (this::isOperand)
                .count ( );
        final int operatorCount = (int) (expressionList.size ( ) - operandCount);
        final boolean isCoherentExpression = ((operatorCount + 1) == operandCount);
        final boolean isOperation = (operatorCount != 0);
        return isCoherentExpression && isOperation;
    }
}
