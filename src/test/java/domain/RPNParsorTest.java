package domain;

import org.junit.Assert;
import org.junit.Test;

public class RPNParsorTest {
    @Test
    public void should_return_empty_when_we_parse_empty_input() {
        Assert.assertEquals ("", new RPNParsor ( ).parse (""));
    }
}
