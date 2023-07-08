package com.example.customerservice.Web;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;
import com.example.customerservice.Entity.Customer;
import com.example.customerservice.Mappers.CustomerMapper;
import com.example.customerservice.Service.CustomerService;
import com.example.customerservice.stub.CustomerServiceGrpc;
import com.example.customerservice.stub.CustomerServiceOuterClass;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class CustomerGRPCService extends CustomerServiceGrpc.CustomerServiceImplBase {

    private CustomerService customerService;
    private CustomerMapper customerMapper;

    public CustomerGRPCService(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @Override
    public void getAllCustomers(CustomerServiceOuterClass.GetAllCustomersRequest request, StreamObserver<CustomerServiceOuterClass.GetCustomersResponse> responseObserver) {

        List<CustomerResponseDTO> customerResponseDTOS = customerService.findAll();
        List<CustomerServiceOuterClass.Customer> customerList = customerResponseDTOS.stream().map(customerMapper::fromCustomer).collect(Collectors.toList());

        CustomerServiceOuterClass.GetCustomersResponse customersResponse =
                CustomerServiceOuterClass.GetCustomersResponse.newBuilder()
                        .addAllCustomer(customerList)
                                .build();
        responseObserver.onNext(customersResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getCustomerById(CustomerServiceOuterClass.GetCustomerByIdRequest request, StreamObserver<CustomerServiceOuterClass.GetCustomerByIdResponse> responseObserver) {
        CustomerResponseDTO customerResponseDTO = customerService.findById(Long.valueOf(request.getCustomeId()));
        CustomerServiceOuterClass.GetCustomerByIdResponse response =
                CustomerServiceOuterClass.GetCustomerByIdResponse.newBuilder()
                        .setCustomer(customerMapper.fromCustomer(customerResponseDTO))
                                .build();


        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void saveCustomer(CustomerServiceOuterClass.SavedCustomerRequest request, StreamObserver<CustomerServiceOuterClass.SaveCustomerResponse> responseObserver) {
        CustomerRequestDTO customerRequestDTO = customerMapper.fromCustomerRequest(request.getCustomer());
        CustomerResponseDTO customerResponseDTO = customerService.save(customerRequestDTO);
        CustomerServiceOuterClass.SaveCustomerResponse response =
                CustomerServiceOuterClass.SaveCustomerResponse.newBuilder()
                        .setCustomer(customerMapper.fromCustomer(customerResponseDTO))
                        .build();


        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
