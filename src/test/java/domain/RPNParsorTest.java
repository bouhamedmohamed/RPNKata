package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPNParsorTest {

    private RPNParsor rpnParsor;

    @Before
    public void setUp() throws Exception {
        rpnParsor = new RPNParsor ( );
    }

    @Test
    public void should_return_empty_when_we_parse_empty_input() {
        Assert.assertEquals ("", rpnParsor.parse (""));
    }

    @Test
    public void should_return_0_when_we_parse_0() {
        Assert.assertEquals ("0", rpnParsor.parse ("0"));
    }

}
