package domain;

import org.junit.Assert;
import org.junit.Test;

public class RPNEvaluatorTest {


    private static final double DELTA = 0.001;

    @Test(expected = NoOperationException.class)
    public void should_return_throw_exception_when_no_operator_match() {
        RPNOperator.findOperation ("");
    }

    @Test
    public void should_return_plus_operator() {
        Assert.assertEquals ("+", RPNOperator.findOperation ("+").getSymbol ( ));
    }

    @Test
    public void should_return_subtract_operator() {
        Assert.assertEquals ("-", RPNOperator.findOperation ("-").getSymbol ( ));
    }

    @Test
    public void should_return_multiple_operator() {
        Assert.assertEquals ("*", RPNOperator.findOperation ("*").getSymbol ( ));
    }

    @Test
    public void should_return_divider_operator() {
        Assert.assertEquals ("/", RPNOperator.findOperation ("/").getSymbol ( ));
    }

    @Test(expected = NoOperationException.class)
    public void should_raise_exception_when_no_operation_match() {
        RPNOperator.findOperation ("!");
    }

    @Test
    public void should_return_3_when_we_add_1_plus_2() {
        final RPNOperator operation = RPNOperator.findOperation ("+");
        Assert.assertEquals (3, operation.calculate (new RPNOperand (1),new RPNOperand (2)).getValue (), DELTA);
    }

    @Test
    public void should_return_8_when_we_add_10_minus_2() {
        final RPNOperator operation = RPNOperator.findOperation ("-");
        Assert.assertEquals (8, operation.calculate (new RPNOperand (10), new RPNOperand (2)).getValue (), DELTA);
    }

    @Test
    public void should_return_8_when_we_add_4_multiple_2() {
        final RPNOperator operation = RPNOperator.findOperation ("*");
        Assert.assertEquals (8, operation.calculate (new RPNOperand (4), new RPNOperand (2)).getValue (), DELTA);
    }

    @Test
    public void should_return_2_when_we_add_4_divided_2() {
        final RPNOperator operation = RPNOperator.findOperation ("/");
        Assert.assertEquals (2, operation.calculate (new RPNOperand (4), new RPNOperand (2)).getValue (), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_raise_exception_when_divided_by_0() {
        final RPNOperator operation = RPNOperator.findOperation ("/");
        operation.calculate (new RPNOperand (4), new RPNOperand (0));

    }
}
