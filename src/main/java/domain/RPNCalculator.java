package domain;

public class RPNCalculator {
    public double calcul(String expression) {
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

        return execute (operandOne, operandTwo, rpnOperator);
    }

    private int getOperand(RPNParsor rpnParsor, String element) {
        int operand = 0;
        if ( rpnParsor.isOperand (element) )
            operand = Integer.parseInt (element);
        return operand;
    }

    private double execute(int operandOne, int operandTwo, RPNOperator rpnOperator) {
        return rpnOperator.calculate (operandOne, operandTwo);
    }
}
