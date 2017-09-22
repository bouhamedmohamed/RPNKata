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

    @Test(expected = NoOperationException.class)
    public void should_return_throw_exception_when_no_operator_match() {
        rpnEvaluator.findOperation ("");
    }

    @Test
    public void should_return_plus_operator() {
        Assert.assertEquals ("+", rpnEvaluator.findOperation ("+").getSymbol ( ));
    }

    @Test
    public void should_return_subtract_operator() {
        Assert.assertEquals ("-", rpnEvaluator.findOperation ("-").getSymbol ( ));
    }

    @Test
    public void should_return_multiple_operator() {
        Assert.assertEquals ("*", rpnEvaluator.findOperation ("*").getSymbol ( ));
    }

    @Test
    public void should_return_divider_operator() {
        Assert.assertEquals ("/", rpnEvaluator.findOperation ("/").getSymbol ( ));
    }

    @Test(expected = NoOperationException.class)
    public void should_raise_exception_when_no_operation_match() {
        rpnEvaluator.findOperation ("!");
    }
}
