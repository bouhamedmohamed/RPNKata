package domain;

public class RPNOperand {
    private final double operand;

    public RPNOperand(double operand) {
        this.operand = operand;
    }

    public RPNOperand(String operandString) {
        this.operand = Double.parseDouble (operandString);
    }

    public double getOperand() {
        return operand;
    }
}
