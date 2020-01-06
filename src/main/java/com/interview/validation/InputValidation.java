package com.interview.validation;

import com.interview.dto.CalculatorDto;
import com.interview.exception.CalculatorCustomException;

public class InputValidation {

    public static Long stringToLong(String numberInString){
        try{
            return Long.parseLong(numberInString);
        }
        catch(Exception e){
            throw new CalculatorCustomException("please enter a valid Number");
        }
    }

    public static String[] validateRequestAndGetNumbers(CalculatorDto calculatorDto) {

        String[] numbers = calculatorDto.getNumbers();
        if (calculatorDto.getNumbers() == null || numbers.length == 0) {
            throw new CalculatorCustomException("please enter a number, the number array is empty");
        } else {
            return numbers;
        }
    }
}
