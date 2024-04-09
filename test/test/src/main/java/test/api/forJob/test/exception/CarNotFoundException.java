package test.api.forJob.test.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String message) {
        super("Car with this id doesn't exists: " + message);
    }
}
