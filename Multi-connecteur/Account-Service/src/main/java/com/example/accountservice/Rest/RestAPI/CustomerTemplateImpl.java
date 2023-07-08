package com.example.accountservice.Rest.RestAPI;

import com.example.accountservice.Model.Customer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerTemplateImpl implements CustomerTemplate {
    private RestTemplate restTemplate;
    private static String path="http://localhost:8081/customer";

    public CustomerTemplateImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Customer> findAll() {
        ResponseEntity<List<Customer>> responseEntity =restTemplate.exchange(
                path + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>(){}
        );
        return responseEntity.getBody();
    }

    @Override
    public Customer findById(Long id) {

        ResponseEntity<Customer> responseEntity =restTemplate.exchange(
                path + "/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Customer>(){}
        );
        return responseEntity.getBody();
    }

    @Override
    public Customer save(Customer customer) {
        Customer customer_saved = restTemplate.postForObject(path + "/create", customer, Customer.class);
        return customer_saved;
    }
}
