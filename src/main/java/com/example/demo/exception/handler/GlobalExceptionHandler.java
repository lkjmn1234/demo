package com.example.demo.exception.handler;

import com.example.demo.exception.DemoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler()
  @ResponseBody
  String handleException(DemoException e) {
    return "You got runtime exception";
  }
}
