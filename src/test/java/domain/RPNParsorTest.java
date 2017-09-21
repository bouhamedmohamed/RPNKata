package domain;

import org.junit.Assert;
import org.junit.Test;

public class RPNParsorTest {
    @Test
    public void should_return_empty_when_we_parse_empty_input() {
        Assert.assertEquals ("", new RPNParsor ( ).parse (""));
    }

    @Test
    public void should_return_0_when_we_parse_0() {
        Assert.assertEquals ("0", new RPNParsor ( ).parse ("0"));
    }

    @Test
    public void should_return_1_when_we_parse_1() {
        Assert.assertEquals ("1", new RPNParsor ( ).parse ("1"));
    }

}
