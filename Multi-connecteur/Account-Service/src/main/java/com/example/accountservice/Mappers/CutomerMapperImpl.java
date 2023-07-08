package com.example.accountservice.Mappers;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.Model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CutomerMapperImpl implements CustomerMapper {
    @Override
    public Customer fromRequestToCustomer(AuthentificationRequestDTO authentificationRequestDTO) {
        Customer customer = new Customer();
        customer.setId(null);
        customer.setNom(authentificationRequestDTO.getNom());
        customer.setEmail(authentificationRequestDTO.getEmail());
        return customer;
    }
}
