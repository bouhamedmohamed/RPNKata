package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RPNParsor {
    List<String> expressionList;
    private AtomicInteger indice;

    public RPNParsor(String expression) {
        this.expressionList = new ArrayList<> ( );
        if ( !expression.isEmpty ( ) )
            this.expressionList = createElements (expression);

        this.indice = new AtomicInteger (0);
    }

    private List createElements(String expression) {
        String[] expressionParsed = expression.split (" ");
        expressionList.addAll (Arrays.asList (expressionParsed));
        return expressionList;
    }


    public String getNext() {
        if ( expressionList.size ( ) > indice.get ( ) )
            return expressionList.get (indice.getAndIncrement ( ));
        return "";
    }
}
