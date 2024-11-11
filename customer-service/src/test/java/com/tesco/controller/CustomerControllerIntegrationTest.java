package com.tesco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tesco.dto.CustomerDTO;
import com.tesco.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private CustomerDTO createSampleCustomerDTO() {
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstname("John");
        dto.setLastname("Doe");
        dto.setEmail("john@email.com");
        dto.setPhone("1234567890");
        dto.setGender("Male");
        dto.setCity("London");
        return dto;
    }
}