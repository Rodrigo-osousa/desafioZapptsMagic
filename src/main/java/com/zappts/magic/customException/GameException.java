package com.zappts.magic.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class GameException extends Exception{
    private static final long serialVersionUID = 1L;

    public GameException(String message) {
        super(message);
    }
}
