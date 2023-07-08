package com.example.customerservice.Service;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;
import com.example.customerservice.Entity.Customer;
import com.example.customerservice.Mappers.CustomerMapper;
import com.example.customerservice.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.fromRequestToCustomer(customerRequestDTO);
        Customer customer_saved = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.fromCustomerToResponse(customer_saved);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        return null;
    }

    @Override
    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) throw new RuntimeException(String.format("Customer %s doesnt exist",id));
        else
        return customerMapper.fromCustomerToResponse(customer);
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customerMapper::fromCustomerToResponse)
                .collect(Collectors.toList());
    }

}
