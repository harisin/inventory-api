package com.upgrad.course.demo.exception.handler;


import com.upgrad.course.demo.dto.ErrorResponse;
import com.upgrad.course.demo.exception.MissingAuthHeaderException;
import com.upgrad.course.demo.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String NO_RECORDS_FOUND = "NO_RECORDS_FOUND";
    private String BAD_REQUEST = "BAD_REQUEST";
    private String INTERNAL_SERVER_ERROR = "Something went wrong.";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(
            RecordNotFoundException ex, WebRequest req) {
        List<String> errorDetails = new ArrayList<String>();
        errorDetails.add(ex.getLocalizedMessage());
        ErrorResponse response = new ErrorResponse(NO_RECORDS_FOUND, errorDetails);

        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingAuthHeaderException.class)
    public final ResponseEntity<ErrorResponse> handleBadInputException(
            MissingAuthHeaderException ex, WebRequest req) {
        List<String> errorDetails = new ArrayList<String>();
        errorDetails.add(ex.getLocalizedMessage());
        ErrorResponse response = new ErrorResponse(BAD_REQUEST, errorDetails);

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public final ResponseEntity<ErrorResponse> handleInternalServerError(
            Exception ex, WebRequest req) {
        List<String> errorDetails = new ArrayList<>();
        errorDetails.add(ex.getLocalizedMessage());
        ErrorResponse response = new ErrorResponse(INTERNAL_SERVER_ERROR, errorDetails);

        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
