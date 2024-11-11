package com.tesco.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotBlank(message = "First name is required")
    private String firstname;

    @NotBlank(message = "Last name is required")
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "City is required")
    private String city;
}