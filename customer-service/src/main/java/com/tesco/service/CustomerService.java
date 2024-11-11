package com.tesco.service;

import com.tesco.dto.CustomerDTO;
import com.tesco.exception.ResourceNotFoundException;
import com.tesco.entity.Customer;
import com.tesco.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = mapToEntity(customerDTO);
        customer.setId(UUID.randomUUID());
        return mapToDTO(customerRepository.save(customer));
    }

    public CustomerDTO getCustomer(UUID id) {
        return mapToDTO(customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO updateCustomer(UUID id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Customer updatedCustomer = mapToEntity(customerDTO);
        updatedCustomer.setId(id);

        return mapToDTO(customerRepository.save(updatedCustomer));
    }

    public void deleteCustomer(UUID id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found");
        }
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstname(customer.getFirstname());
        dto.setLastname(customer.getLastname());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setGender(customer.getGender());
        dto.setCity(customer.getCity());
        return dto;
    }

    private Customer mapToEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFirstname(dto.getFirstname());
        customer.setLastname(dto.getLastname());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setGender(dto.getGender());
        customer.setCity(dto.getCity());
        return customer;
    }
}