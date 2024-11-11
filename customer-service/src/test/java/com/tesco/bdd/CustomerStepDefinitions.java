package com.tesco.bdd;

import com.tesco.dto.CustomerDTO;
import com.tesco.exception.ResourceNotFoundException;
import com.tesco.service.CustomerService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CustomerStepDefinitions {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerService customerService; // This is now a mock

    private CustomerDTO customerDTO;
    private CustomerDTO responseDTO;
    private UUID customerId;
    private String baseUrl;
    private HttpHeaders headers;
    private ResponseEntity<CustomerDTO> response;
    private Exception exception;
    private CustomerDTO updateDTO;

    @Before
    public void setup() {
        baseUrl = "http://localhost:" + port + "/api/customers";
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        customerId = UUID.randomUUID();
    }

}