package com.example.accountservice.Rest.RestAPI;

import com.example.accountservice.Model.Customer;

import java.util.List;

public interface CustomerTemplate {

    List<Customer> findAll();
    Customer findById(Long id);
    Customer save(Customer customer);

}
