package domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class RPNParsorTest {
    @Test
    public void should_return_empty_when_we_parse_empty_input() {
        final RPNParsor expressionParsed = new RPNParsor ("");
        Assert.assertEquals ("", expressionParsed.getNext ());
    }

    @Test
    public void should_return_0_when_we_parse_0() {
        final RPNParsor expressionParsed = new RPNParsor ("0 ");
        Assert.assertEquals ("0", expressionParsed.getNext ());
    }

    @Test
    public void should_return_1_when_we_parse_1() {
        final RPNParsor expressionParsed = new RPNParsor ("1 ");
        Assert.assertEquals ("1", expressionParsed.getNext ());
    }

    @Test
    public void should_return_1_0_when_we_parse_1_0() {
        final RPNParsor expressionParsed = new RPNParsor ("1 0 ");
        Assert.assertEquals ("1", expressionParsed.getNext ());
        Assert.assertEquals ("0", expressionParsed.getNext ());
    }

    @Test
    public void should_return_1_0_when_we_parse_1_0_plus() {
        final RPNParsor expressionParsed = new RPNParsor ("1 0 + ");
        Assert.assertEquals ("1", expressionParsed.getNext ());
        Assert.assertEquals ("0", expressionParsed.getNext ());
        Assert.assertEquals ("+", expressionParsed.getNext ());
    }
}