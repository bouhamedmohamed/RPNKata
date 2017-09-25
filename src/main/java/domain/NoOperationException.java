package domain;

class NoOperationException extends RuntimeException {
    public NoOperationException() {
        super("No operation match");
    }
}
