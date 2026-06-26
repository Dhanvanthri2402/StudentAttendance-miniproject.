package com.example.demo.Exceptions;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;



@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> Handlevalidationexceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
        {
            errors.put(error.getField(), error.getDefaultMessage());
        });


        return errors;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String,String> handleAllOtherExceptions(Exception ex){
        Map<String,String> errors = new HashMap<>();
        errors.put("error","Server crashed try after sometime");
        errors.put("details", ex.getMessage());
        return errors;
    }
}
