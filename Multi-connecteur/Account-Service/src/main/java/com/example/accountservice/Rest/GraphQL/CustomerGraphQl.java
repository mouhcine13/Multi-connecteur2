package com.example.accountservice.Rest.GraphQL;

import com.example.accountservice.Model.Customer;

import java.util.List;

public interface CustomerGraphQl {

    Customer save(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
}
