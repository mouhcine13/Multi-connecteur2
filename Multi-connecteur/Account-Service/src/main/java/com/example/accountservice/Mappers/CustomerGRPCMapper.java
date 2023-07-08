package com.example.accountservice.Mappers;

import com.example.accountservice.Model.Customer;
import com.example.customerservice.stub.CustomerServiceOuterClass;

public interface CustomerGRPCMapper {

    Customer fromGRPCToCustomer(CustomerServiceOuterClass.Customer customersResponse);

    CustomerServiceOuterClass.Customer fromCustomerToGRPC(Customer customer);
}
