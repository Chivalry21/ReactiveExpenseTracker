package com.chivalrycode.expensetracker.exception;

import org.springframework.http.HttpStatus;
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
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String,String> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        HashMap<String, String> err = new HashMap<>();
        err.put("error", "Invalid input type! Please recheck your input");
        return err;

    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String,String> handleBadRequestException(BadRequestException e) {
        HashMap<String, String> err = new HashMap<>();
        err.put("error",e.getMessage());
        System.out.println("something went wrong");
        return err;

    }
}
