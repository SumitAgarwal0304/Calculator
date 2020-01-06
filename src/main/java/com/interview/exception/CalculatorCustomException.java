package com.interview.exception;

public class CalculatorCustomException extends RuntimeException {
    public CalculatorCustomException(String message){
        super(message);
    }
}
