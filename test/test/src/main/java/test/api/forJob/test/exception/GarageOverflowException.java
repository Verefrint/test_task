package test.api.forJob.test.exception;

public class GarageOverflowException extends RuntimeException {

    public GarageOverflowException(String message) {
        super("Garage overflow max car value is: " + message);
    }
}
