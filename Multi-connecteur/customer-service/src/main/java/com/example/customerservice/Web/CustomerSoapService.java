package com.example.customerservice.Web;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;
import com.example.customerservice.Service.CustomerService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "CustomerWS")
public class CustomerSoapService {

    private CustomerService customerService;

    public CustomerSoapService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @WebMethod
    public List<CustomerResponseDTO> findAll(){
        return customerService.findAll();
    }

    @WebMethod
    public CustomerResponseDTO findById(@WebParam(name = "id") Long id){
        return customerService.findById(id);
    }

    @WebMethod
    public CustomerResponseDTO save(@WebParam CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }
}
