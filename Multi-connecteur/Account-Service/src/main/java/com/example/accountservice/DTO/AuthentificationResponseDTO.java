package com.example.accountservice.DTO;

import com.example.accountservice.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class AuthentificationResponseDTO {

    private Long id;
    private String email;
    private String motdepasse;
    private Customer customer;
}
