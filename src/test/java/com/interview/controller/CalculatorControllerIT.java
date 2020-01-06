
package com.interview.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.dto.CalculatorDto;
import com.interview.service.CalculatorService;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CalculatorService calculatorService;


    @Test
    @WithMockUser(roles="User")
    public void getMultiplicationResult_When_Forbidden() throws Exception {
        String uri = "/calculator/multiplication";
        CalculatorDto calculatorDto = new CalculatorDto();
        String[] numbers = {"1","3","7"};
        calculatorDto.setNumbers(numbers);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(calculatorDto))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.FORBIDDEN.value(),status);

    }

    @Test
    public void getMultiplicationResult_When_Unauthorized() throws Exception {
        String uri = "/calculator/multiplication";
        CalculatorDto calculatorDto = new CalculatorDto();
        String[] numbers = {"1","3","7"};
        calculatorDto.setNumbers(numbers);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(calculatorDto))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.UNAUTHORIZED.value(),status);

    }


    @Test
    @WithMockUser(roles="ADMIN")
    public void getMultiplicationResult_When_200() throws Exception {
        String uri = "/calculator/multiplication";
        CalculatorDto calculatorDto = new CalculatorDto();
        String[] numbers = {"1","3","7"};
        calculatorDto.setNumbers(numbers);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(calculatorDto))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(),status);

    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void getSubtractionResult() throws Exception{
        String uri = "/calculator/subtraction";
        CalculatorDto calculatorDto = new CalculatorDto();
        String[] numbers = {"3","1"};
        calculatorDto.setNumbers(numbers);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(calculatorDto))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(),status);
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void getEqualResult() throws Exception{
        String uri = "/calculator/subtraction";
        CalculatorDto calculatorDto = new CalculatorDto();
        String[] numbers = {"1","3"};
        calculatorDto.setNumbers(numbers);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(calculatorDto))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(),status);

    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
