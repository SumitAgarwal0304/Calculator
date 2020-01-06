package com.interview.validation;

import static org.junit.Assert.assertEquals;

import com.interview.dto.CalculatorDto;
import com.interview.exception.CalculatorCustomException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InputValidationTest {

    @Test
    public void stringToLong() {
        String number = "2";
        long longNumber = InputValidation.stringToLong(number);
        assertEquals(2,longNumber);
    }

    @Test(expected = CalculatorCustomException.class)
    public void stringToLong_Exception() {
        String number = "notANumber";
        InputValidation.stringToLong(number);
    }

    @Test
    public void validateRequestAndGetNumbers() {
        CalculatorDto calculatorDto = new CalculatorDto();
        String[] numbers = {"1","2"};
        calculatorDto.setNumbers(numbers);
        String[] outputNumbers = InputValidation.validateRequestAndGetNumbers(calculatorDto);
        assertEquals(numbers[0],outputNumbers[0]);
        assertEquals(numbers[1],outputNumbers[1]);
    }

    @Test(expected = CalculatorCustomException.class)
    public void validateRequestAndGetNumbers_When_Exception() {
        CalculatorDto calculatorDto = new CalculatorDto();
        String[] numbers = {};
        calculatorDto.setNumbers(numbers);
        InputValidation.validateRequestAndGetNumbers(calculatorDto);
    }
}