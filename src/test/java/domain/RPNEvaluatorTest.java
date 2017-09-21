package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPNEvaluatorTest {

    private RPNEvaluator rpnEvaluator;

    @Before
    public void setUp() throws Exception {
        rpnEvaluator = new RPNEvaluator ( );
    }

    @Test(expected = NOOperationException.class)
    public void should_return_throw_exception_when_no_operator_match() {
        rpnEvaluator.findOperation ("");
    }

    @Test
    public void should_return_throw_exception_when_no_oprator_match() {
        Assert.assertEquals ("+", rpnEvaluator.findOperation ("+"));
    }
}
