package com.example.customerservice.Web;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;
import com.example.customerservice.Service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Controller
public class CustomerGraphQlController {

    private CustomerService  customerService;

    public CustomerGraphQlController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public List<CustomerResponseDTO> findAll(){
        return customerService.findAll();
    }

    @QueryMapping
    public CustomerResponseDTO findByid(@Argument Long id){
        return customerService.findById(id);
    }

    @MutationMapping
    public CustomerResponseDTO save(@Argument CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }
}
