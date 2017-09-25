package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPNCalculatorTest {

    private static final double DELTA = 0.001;
    private RPNCalculator rpnCalculator;

    @Before
    public void setUp() throws Exception {
        rpnCalculator = new RPNCalculator ( );
    }


    @Test(expected = InvalidExpressionException.class)
    public void should_raise_exception_when_no_valid_expression() throws Exception {
        rpnCalculator.calculate ("1");

    }

    @Test
    public void should_return_2_when_1_plus_1() throws Exception {
        Assert.assertEquals (2, rpnCalculator.calculate ("1 1 +").getValue (),DELTA);

    }

    @Test
    public void should_return_0_when_1_minus_1() throws Exception {
        Assert.assertEquals (0, rpnCalculator.calculate ("1 1 -").getValue (),DELTA);
    }

    @Test
    public void should_return_1_when_1_multiple_1() throws Exception {
        Assert.assertEquals (1, rpnCalculator.calculate ("1 1 *").getValue (),DELTA);
    }

    @Test
    public void should_return_2_when_6_divided_by_3() throws Exception {
        Assert.assertEquals (2, rpnCalculator.calculate ("6 3 /").getValue (), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_raise_an_exception_when_divide_by_0() throws Exception {
        rpnCalculator.calculate ("6 0 /");
    }
    @Test
    public void should_return_5_when_1_plus_3_plus_1() throws Exception {
        Assert.assertEquals (5, rpnCalculator.calculate ("1 3 + 1 +").getValue (), DELTA);
    }
    @Test
    public void should_return_5_when_big_expression() throws Exception {
        Assert.assertEquals (5, rpnCalculator.calculate ("15 7 1 1 + - / 3 * 2 1 1 + + -").getValue (), DELTA);
    }
}
