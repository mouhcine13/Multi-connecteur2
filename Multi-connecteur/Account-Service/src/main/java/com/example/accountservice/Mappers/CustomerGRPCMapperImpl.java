package com.example.accountservice.Mappers;

import com.example.accountservice.Model.Customer;
import com.example.customerservice.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerGRPCMapperImpl implements CustomerGRPCMapper {
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public Customer fromGRPCToCustomer(CustomerServiceOuterClass.Customer customersResponse) {
        return modelMapper.map(customersResponse,Customer.class);
    }

    @Override
    public CustomerServiceOuterClass.Customer fromCustomerToGRPC(Customer customer) {

        return modelMapper.map(customer,CustomerServiceOuterClass.Customer.class);
    }


}
