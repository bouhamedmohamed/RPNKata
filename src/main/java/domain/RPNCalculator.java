package domain;

public class RPNCalculator {
    public int calcul(String expression) {
        RPNParsor rpnParsor = new RPNParsor (expression);
        if ( !rpnParsor.isValid ( ) )
            throw new InvalidExpressionException ( );

        String element = rpnParsor.getNext ( );
        int operandOne = getOperand (rpnParsor, element);
        String elementTwo = rpnParsor.getNext ( );
        int operandTwo = getOperand (rpnParsor, elementTwo);

        String elementThree = rpnParsor.getNext ( );
        RPNOperator rpnOperator = null;
        if ( !rpnParsor.isOperand (elementThree) )
            rpnOperator = RPNOperator.findOperation (elementThree);

        return calcul (operandOne, operandTwo, rpnOperator);
    }

    private int getOperand(RPNParsor rpnParsor, String element) {
        int operand = 0;
        if ( rpnParsor.isOperand (element) )
            operand = Integer.parseInt (element);
        return operand;
    }

    private int calcul(int operandOne, int operandTwo, RPNOperator rpnOperator) {
        if ( rpnOperator.getSymbol ( ).equals ("+") )
            return rpnOperator.add (operandOne, operandTwo);
        if ( rpnOperator.getSymbol ( ).equals ("-") )
            return rpnOperator.sub (operandOne, operandTwo);
        if ( rpnOperator.getSymbol ( ).equals ("*") )
            return rpnOperator.multiple (operandOne, operandTwo);
        if ( rpnOperator.getSymbol ( ).equals ("/") )
            return rpnOperator.divided (operandOne, operandTwo);

        throw new NoOperationException ( );
    }
}
