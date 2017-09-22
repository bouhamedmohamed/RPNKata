package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPNCalculatorTest {

    private RPNCalculator rpnCalculator;

    @Before
    public void setUp() throws Exception {
        rpnCalculator = new RPNCalculator ( );
    }

    @Test(expected = InvalidExpressionException.class)
    public void should_raise_exception_when_no_valid_expression() throws Exception {
        rpnCalculator.calcul ("1");

    }

    @Test
    public void should_return_2_when_1_plus_1() throws Exception {
        Assert.assertEquals (2, rpnCalculator.calcul ("1 1 +"));

    }

    @Test
    public void should_return_0_when_1_minus_1() throws Exception {
        Assert.assertEquals (0, rpnCalculator.calcul ("1 1 -"));
    }

    @Test
    public void should_return_1_when_1_multiple_1() throws Exception {
        Assert.assertEquals (1, rpnCalculator.calcul ("1 1 *"));
    }

    @Test
    public void should_return_2_when_6_divided_by_3() throws Exception {
        Assert.assertEquals (2, rpnCalculator.calcul ("6 3 /"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_raise_an_exception_when_divide_by_0() throws Exception {
        rpnCalculator.calcul ("6 0 /");
    }
}
