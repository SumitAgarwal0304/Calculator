package com.interview.controller;

import com.interview.dto.CalculatorDto;
import com.interview.exception.CalculatorCustomException;
import com.interview.service.CalculatorService;
import com.interview.validation.InputValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @PostMapping("/multiplication")
    public Long getMultiplicationResult(@RequestBody CalculatorDto calculatorDto){
        String[] numbers = InputValidation.validateRequestAndGetNumbers(calculatorDto);
        return calculatorService.getMultiplicationResult(numbers);
    }

    @PostMapping("/subtraction")
    public Long getSubtractionResult(@RequestBody CalculatorDto calculatorDto){
        String[] numbers = InputValidation.validateRequestAndGetNumbers(calculatorDto);
        return calculatorService.getSubtractionResult(numbers);
    }

    @PostMapping("/equal")
    public Boolean getEqualResult(@RequestBody CalculatorDto calculatorDto){
        String[] numbers = InputValidation.validateRequestAndGetNumbers(calculatorDto);
        return calculatorService.getEqualResult(numbers);
    }



}
