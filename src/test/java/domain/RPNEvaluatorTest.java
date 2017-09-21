package domain;

import org.junit.Test;

public class RPNEvaluatorTest {
    @Test(expected = NOOperationException.class)
    public void should_return_throw_exception_when_no_operator_match() {
        new RPNEvaluator ( ).findOperation ("");
    }
}
