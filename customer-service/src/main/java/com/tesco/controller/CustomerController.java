package com.tesco.controller;

import com.tesco.dto.CustomerDTO;
import com.tesco.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO dto = customerService.createCustomer(customerDTO);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID id) {
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable UUID id,
            @Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
