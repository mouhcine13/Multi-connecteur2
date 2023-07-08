package com.example.accountservice.Mappers;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.Model.Customer;
import com.example.customerservice.web.CustomerRequestDTO;
import com.example.customerservice.web.CustomerResponseDTO;

public interface CustomerSOAPMapper {

    Customer fromSoapToCustomer(CustomerResponseDTO customerResponseDTO);
    CustomerRequestDTO fromAuthentificationToRequest(AuthentificationRequestDTO authentificationRequestDTO);
}
