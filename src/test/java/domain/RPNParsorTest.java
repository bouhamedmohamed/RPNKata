package domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class RPNParsorTest {
    @Test
    public void should_return_empty_when_we_parse_empty_input() {
        Assert.assertEquals (Collections.EMPTY_LIST, new RPNParsor ( ).parse (""));
    }

    @Test
    public void should_return_0_when_we_parse_0() {
        Assert.assertEquals (Arrays.asList ("0"), new RPNParsor ( ).parse ("0 "));
    }

    @Test
    public void should_return_1_when_we_parse_1() {
        Assert.assertEquals (Arrays.asList ("1"), new RPNParsor ( ).parse ("1 "));
    }

    @Test
    public void should_return_1_0_when_we_parse_1_0() {
        Assert.assertEquals (Arrays.asList ("1", "0"), new RPNParsor ( ).parse ("1 0 "));
    }

}
