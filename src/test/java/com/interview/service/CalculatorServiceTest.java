package com.interview.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.interview.exception.CalculatorCustomException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

    @InjectMocks
    CalculatorService calculatorService;

    @Test
    public void getMultiplicationResult() {
        String[] numbers = {"1","2","3"};
        long result = calculatorService.getMultiplicationResult(numbers);
        assertEquals(6,result);
    }

    @Test(expected = CalculatorCustomException.class)
    public void getMultiplicationResult_Exception() {
        String[] numbers = {"1","2","Not_A_Number"};
        calculatorService.getMultiplicationResult(numbers);
    }

    @Test
    public void getSubtractionResult() {
        String[] numbers = {"3","2"};
        long result = calculatorService.getSubtractionResult(numbers);
        assertEquals(1,result);
    }

    @Test(expected = CalculatorCustomException.class)
    public void getSubtractionResult_Exception_More_Than_Two_Numbers() {
        String[] numbers = {"3","2","5"};
        calculatorService.getSubtractionResult(numbers);
    }

    @Test
    public void getEqualResult() {
        String[] numbers = {"3","3"};
        boolean result = calculatorService.getEqualResult(numbers);
        assertTrue(result);
    }

}