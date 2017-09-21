package domain;

public class RPNEvaluator {
    public void findOperation(String s) {
        if(s.isEmpty ())
            throw new NOOperationException();
    }
}
