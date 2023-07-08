package com.example.accountservice.Mappers;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.Model.Customer;
import com.example.customerservice.web.CustomerRequestDTO;
import com.example.customerservice.web.CustomerResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerSOAPMapperImpl implements CustomerSOAPMapper {
    @Override
    public Customer fromSoapToCustomer(CustomerResponseDTO customerResponseDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerResponseDTO,customer);
        return customer;
    }

    @Override
    public CustomerRequestDTO fromAuthentificationToRequest(AuthentificationRequestDTO authentificationRequestDTO) {

        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();

        customerRequestDTO.setEmail(authentificationRequestDTO.getEmail());
        customerRequestDTO.setNom(authentificationRequestDTO.getNom());
        return customerRequestDTO;
    }
}
