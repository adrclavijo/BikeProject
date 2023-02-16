package es.aclavijo.bikeapp.config.handler;

import es.aclavijo.bikeapp.bike.exceptions.BikeNotFoundException;
import es.aclavijo.bikeapp.config.ExceptionResponse;
import lombok.extern.log4j.Log4j2;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BikeNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleNotFoundException(BikeNotFoundException exception, WebRequest request) {
        var exceptionResponse = ExceptionResponse.fromRequest(request);
        exceptionResponse.setStatus(NOT_FOUND);
        exceptionResponse.setDetails(exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionResponse> handleGenericException(Exception exception, WebRequest request) {
        var exceptionResponse = ExceptionResponse.fromRequest(request);
        exceptionResponse.setStatus(INTERNAL_SERVER_ERROR);
        exceptionResponse.setDetails(exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(exceptionResponse, INTERNAL_SERVER_ERROR);
    }

}
