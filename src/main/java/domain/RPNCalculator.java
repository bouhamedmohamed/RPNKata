package domain;

import java.util.Stack;

public class RPNCalculator {
    public RPNOperand calcul(String expression) {
        RPNParsor rpnParsor = new RPNParsor (expression);
        if ( !rpnParsor.isValid ( ) )
            throw new InvalidExpressionException ( );

        Stack<String> operands = new Stack<> ( );
        String element = rpnParsor.getNext ( );
        do {
            if ( rpnParsor.isOperand (element) )
                operands.push (element);
            else {
                RPNOperand operandTwo = new RPNOperand (operands.pop ( ));
                RPNOperand operandOne = new RPNOperand (operands.pop ( ));
                RPNOperator rpnOperator = RPNOperator.findOperation (element);
                RPNOperand operationResult = rpnOperator.calculate (operandOne, operandTwo);
                operands.push (String.valueOf (operationResult.getOperand ()));
            }

            element = rpnParsor.getNext ( );
        } while (!element.equals (""));

        return new RPNOperand (operands.pop ( ));

    }
}
