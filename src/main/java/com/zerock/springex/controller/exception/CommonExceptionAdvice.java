package com.zerock.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException){
        log.error("-----------------------------------");
        log.error(numberFormatException.getMessage());
        return "number format exception";
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        // 화면 이동
        return "custom404";
    }
}
