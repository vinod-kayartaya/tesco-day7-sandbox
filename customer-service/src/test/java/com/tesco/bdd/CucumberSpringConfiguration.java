package com.tesco.bdd;

import com.tesco.service.CustomerService;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestConfig.class)
public class CucumberSpringConfiguration {
    @MockBean
    public CustomerService customerService;
}