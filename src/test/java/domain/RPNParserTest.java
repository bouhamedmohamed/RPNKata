package domain;

import org.junit.Assert;
import org.junit.Test;

public class RPNParserTest {

    @Test
    public void should_return_empty_when_we_parse_empty_input() {
        final RPNParser expressionParsed = new RPNParser ("");
        Assert.assertEquals ("", expressionParsed.getNext ( ));
    }

    @Test
    public void should_return_0_when_we_parse_0() {
        final RPNParser expressionParsed = new RPNParser ("0 ");
        Assert.assertEquals ("0", expressionParsed.getNext ( ));
    }

    @Test
    public void should_return_1_when_we_parse_1() {
        final RPNParser expressionParsed = new RPNParser ("1 ");
        Assert.assertEquals ("1", expressionParsed.getNext ( ));
    }

    @Test
    public void should_return_1_0_when_we_parse_1_0() {
        final RPNParser expressionParsed = new RPNParser ("1 0 ");
        Assert.assertEquals ("1", expressionParsed.getNext ( ));
        Assert.assertEquals ("0", expressionParsed.getNext ( ));
    }

    @Test
    public void should_return_1_0_when_we_parse_1_0_plus() {
        final RPNParser expressionParsed = new RPNParser ("1 0 + ");
        Assert.assertEquals ("1", expressionParsed.getNext ( ));
        Assert.assertEquals ("0", expressionParsed.getNext ( ));
        Assert.assertEquals ("+", expressionParsed.getNext ( ));
    }

    @Test
    public void should_evaluate_elements() {
        final RPNParser expressionParsed = new RPNParser ("1 0 + ");
        final String firstElement = expressionParsed.getNext ( );
        final String secondElement = expressionParsed.getNext ( );
        final String thirdElement = expressionParsed.getNext ( );
        Assert.assertEquals ("1", firstElement);
        Assert.assertEquals ("0", secondElement);
        Assert.assertEquals ("+", thirdElement);
        Assert.assertEquals (true, expressionParsed.isOperand (firstElement));
        Assert.assertEquals (true, expressionParsed.isOperand (secondElement));
        Assert.assertEquals (false, expressionParsed.isOperand (thirdElement));
    }

    @Test
    public void should_evaluate_is_valid_expression() throws InvalidExpressionException {
        final RPNParser expressionParsed = new RPNParser ("1 0 + ");
        Assert.assertEquals (true, expressionParsed.isValid ( ));
    }

    @Test(expected = InvalidExpressionException.class)
    public void should_evaluate_is_invalid_expression() throws InvalidExpressionException {
        final RPNParser expressionParsed = new RPNParser ("1 0 + + +");
        Assert.assertEquals (false, expressionParsed.isValid ( ));
    }
}