package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RPNParsor {
    public List parse(String expression) {
        if ( expression.isEmpty ( ) )
            return Collections.EMPTY_LIST;
        else
            return createElements (expression);

    }

    private List createElements(String expression) {
        String[] expressionParsed = expression.split (" ");
        return Arrays.asList (expressionParsed);
    }
}
