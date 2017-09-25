package domain;

import java.util.Stack;

class RPNCalculator {

    private static final String EMPTY_Result = "";

    public RPNOperand calculate(String expression) {
        RPNParser rpnParser = new RPNParser (expression);
        if ( !rpnParser.isValid ( ) )
            throw new InvalidExpressionException ( );

        Stack<String> operands = new Stack<> ( );
        String element = rpnParser.getNext ( );
        do {
            if ( rpnParser.isOperand (element) )
                operands.push (element);
            else {
                RPNOperand operandTwo = new RPNOperand (operands.pop ( ));
                RPNOperand operandOne = new RPNOperand (operands.pop ( ));
                RPNOperator rpnOperator = RPNOperator.findOperation (element);
                RPNOperand operationResult = rpnOperator.calculate (operandOne, operandTwo);
                operands.push (String.valueOf (operationResult.getValue ()));
            }

            element = rpnParser.getNext ( );
        } while (!element.equals (EMPTY_Result));

        return new RPNOperand (operands.pop ( ));

    }
}
