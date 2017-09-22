package domain;

import org.junit.Test;

public class RPNCalculatorTest {
    @Test(expected = InvalidExpression.class)
    public void should_raise_exception_when_no_valid_expression() throws Exception {
        new RPNCalculator ( ).calcul ("1");

    }
}
