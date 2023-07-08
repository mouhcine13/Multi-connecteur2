package com.example.customerservice.Service;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO findById(Long id);
    List<CustomerResponseDTO> findAll();
}
