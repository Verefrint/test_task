package test.api.forJob.test.api.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import test.api.forJob.test.api.dto.ErrorDTO;
import test.api.forJob.test.exception.CarNotFoundException;
import test.api.forJob.test.exception.GarageNotFoundException;
import test.api.forJob.test.exception.GarageOverflowException;

@Slf4j
@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransportControllerAdvice {

    @ExceptionHandler(CarNotFoundException.class)
    public ErrorDTO badGetCarByIdRequest(CarNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(GarageNotFoundException.class)
    public ErrorDTO badGetGarageByIdRequest(GarageNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(GarageOverflowException.class)
    public ErrorDTO badCreateCarRequest(GarageOverflowException e) {
        log.error(e.getMessage());
        return new ErrorDTO(e.getMessage());
    }
}
