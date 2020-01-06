package com.interview.service;

import com.interview.exception.CalculatorCustomException;
import com.interview.validation.InputValidation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Long getMultiplicationResult(String[] numbers){
        Long result = 1L;
       for(String number : numbers){
           result = InputValidation.stringToLong(number) * result ;
       }
       return result;
    }

    public Long getSubtractionResult(String[] numbers) {
        if(numbers.length > 2){
            throw new CalculatorCustomException("Please enter two numbers for Subtraction");
        }
        Long result = InputValidation.stringToLong(numbers[0]) - InputValidation.stringToLong(numbers[1]);
        return result;
    }

    public Boolean getEqualResult(String[] numbers) {
        return numbers[0].equals(numbers[1]);
    }

}
