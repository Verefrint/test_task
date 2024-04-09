package test.api.forJob.test.exception;

public class GarageNotFoundException extends RuntimeException {

    public GarageNotFoundException(String message) {
        super("Garage with this id doesn't exists: " + message);
    }
}
