package com.example.customerservice.Mappers;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;
import com.example.customerservice.Entity.Customer;
import com.example.customerservice.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public Customer fromRequestToCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequestDTO,customer);
        return customer;
    }

    @Override
    public CustomerResponseDTO fromCustomerToResponse(Customer customer) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        BeanUtils.copyProperties(customer,customerResponseDTO);
        return customerResponseDTO;
    }

    @Override
    public CustomerServiceOuterClass.Customer fromCustomer(CustomerResponseDTO customerResponseDTO) {
        return modelMapper.map(customerResponseDTO,CustomerServiceOuterClass.Customer.Builder.class).build();
    }

    @Override
    public CustomerRequestDTO fromCustomerRequest(CustomerServiceOuterClass.CustomerRequest customer) {
        return modelMapper.map(customer,CustomerRequestDTO.class);
    }
}
