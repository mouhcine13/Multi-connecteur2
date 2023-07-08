package com.example.accountservice.Mappers;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.Model.Customer;

public interface CustomerMapper {

    Customer fromRequestToCustomer(AuthentificationRequestDTO authentificationRequestDTO);
}
