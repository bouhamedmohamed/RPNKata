package domain;

import java.util.Stack;

public class RPNCalculator {
    public double calcul(String expression) {
        RPNParsor rpnParsor = new RPNParsor (expression);
        if ( !rpnParsor.isValid ( ) )
            throw new InvalidExpressionException ( );

        Stack<String> operands = new Stack<> ( );
        String element = rpnParsor.getNext ( );
        do {
            if ( rpnParsor.isOperand (element) )
                operands.push (element);
            else
            {
                double operandTwo = Double.parseDouble (operands.pop ( ));
                double operandOne = Double.parseDouble (operands.pop ( ));
                RPNOperator rpnOperator = RPNOperator.findOperation (element);
                final double operationResult = rpnOperator.calculate (operandOne, operandTwo);
                operands.push (String.valueOf (operationResult));
            }

            element = rpnParsor.getNext ( );
        } while (!element.equals (""));

        return Double.parseDouble (operands.pop ( ));

    }
}
