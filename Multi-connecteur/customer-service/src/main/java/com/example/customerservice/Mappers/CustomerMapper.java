package com.example.customerservice.Mappers;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;
import com.example.customerservice.Entity.Customer;
import com.example.customerservice.stub.CustomerServiceOuterClass;

public interface CustomerMapper {

    Customer fromRequestToCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO fromCustomerToResponse(Customer customer);

    CustomerServiceOuterClass.Customer fromCustomer(CustomerResponseDTO customerResponseDTO);

    CustomerRequestDTO fromCustomerRequest(CustomerServiceOuterClass.CustomerRequest customer);
}
