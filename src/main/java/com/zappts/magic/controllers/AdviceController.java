package com.zappts.magic.controllers;


import com.zappts.magic.customException.GameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(GameException.class)
    public ResponseEntity<String> handleBadRequestInput(GameException gameException) {
        return new ResponseEntity<String>(gameException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
