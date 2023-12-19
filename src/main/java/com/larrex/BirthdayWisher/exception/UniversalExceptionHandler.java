package com.larrex.BirthdayWisher.exception;

import com.larrex.BirthdayWisher.exception.model.ErrorObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class UniversalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorObj> handleApiUserNotFound(ItemNotFoundException exception, WebRequest request){

        ErrorObj errorObj = new ErrorObj();
        errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObj.setMessage(exception.getMessage());
        errorObj.setTimestamp(new Date());

        return new ResponseEntity<>(errorObj,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleUniversalException(Exception exception,WebRequest request){

        ErrorObj errorObj = new ErrorObj();
        errorObj.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorObj.setMessage(exception.getMessage());
        errorObj.setTimestamp(new Date());

        return new ResponseEntity<>(errorObj,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
