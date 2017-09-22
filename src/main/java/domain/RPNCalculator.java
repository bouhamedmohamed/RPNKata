package domain;

public class RPNCalculator {
    public int calcul(String expression) {
        RPNParsor rpnParsor = new RPNParsor (expression);
        if ( !rpnParsor.isValid ( ) )
            throw new InvalidExpressionException ( );

        String element = rpnParsor.getNext ( );
        int operandOne = 0;
        if ( rpnParsor.isOperand (element) )
            operandOne = Integer.parseInt (element);
        String elementTwo = rpnParsor.getNext ( );
        int operandTwo = 0;
        if ( rpnParsor.isOperand (elementTwo) )
            operandTwo = Integer.parseInt (elementTwo);

        String elementThree = rpnParsor.getNext ( );
        RPNOperator rpnOperator = null;
        if ( !rpnParsor.isOperand (elementThree) )
            rpnOperator = RPNOperator.findOperation (elementThree);

        if ( rpnOperator.getSymbol ( ).equals ("+") )
            return rpnOperator.add (operandOne, operandTwo);

        if ( rpnOperator.getSymbol ( ).equals ("-") )
            return rpnOperator.sub (operandOne, operandTwo);
        else
            return rpnOperator.multiple (operandOne, operandTwo);

    }
}
