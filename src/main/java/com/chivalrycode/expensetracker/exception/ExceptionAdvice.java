package com.chivalrycode.expensetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String,String> handleError(MethodArgumentNotValidException ex){
        HashMap<String,String> error = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(e ->{
                    error.put(e.getField(),e.getDefaultMessage());
                    System.out.println(e.getField()+ ": " + e.getDefaultMessage());
                });
        //System.out.println(ex);
        return error;
    }
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String,String> handleBadCredentials(BadCredentialsException e){
        HashMap <String, String> err = new HashMap<>();
        err.put("error","invalid username or password");
        return err;
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String,String> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        HashMap<String, String> err = new HashMap<>();
        err.put("error", "Invalid input type! Please recheck your input");
        return err;

    }
}