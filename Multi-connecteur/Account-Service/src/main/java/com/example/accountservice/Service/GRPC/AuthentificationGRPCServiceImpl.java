package com.example.accountservice.Service.GRPC;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Entity.Authentification;
import com.example.accountservice.Mappers.AuthentificationMapper;
import com.example.accountservice.Mappers.CustomerGRPCMapper;
import com.example.accountservice.Model.Customer;
import com.example.accountservice.Repository.AuthentificationRepository;
import com.example.customerservice.stub.CustomerServiceGrpc;
import com.example.customerservice.stub.CustomerServiceOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AuthentificationGRPCServiceImpl implements AuthentificationGRPCService {
    private AuthentificationRepository authentificationRepository;
    private AuthentificationMapper authentificationMapper;
    private CustomerGRPCMapper customerGRPCMapper;

    @GrpcClient(value = "customerService")
    private CustomerServiceGrpc.CustomerServiceBlockingStub customerServiceBlockingStub;


    public AuthentificationGRPCServiceImpl(AuthentificationRepository authentificationRepository, AuthentificationMapper authentificationMapper, CustomerGRPCMapper customerGRPCMapper) {
        this.authentificationRepository = authentificationRepository;
        this.authentificationMapper = authentificationMapper;
        this.customerGRPCMapper = customerGRPCMapper;
    }

    @Override
    public AuthentificationResponseDTO save(AuthentificationRequestDTO authentificationRequestDTO) {
        return null;
    }

    @Override
    public AuthentificationResponseDTO findById(Long id) {
        Authentification authentification = authentificationRepository.findById(id).orElse(null);
        Customer customer = getCustomer(authentification.getId());
        AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(authentification, customer);
        return authentificationResponseDTO;
    }

    @Override
    public List<AuthentificationResponseDTO> findAll() {
        List<Authentification> authentificationList = authentificationRepository.findAll();
        List<AuthentificationResponseDTO> authentificationResponseDTOList = new ArrayList<>();
        for (Authentification index : authentificationList) {
            Customer customer = getCustomer(index.getId());
            AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(index, customer);
            authentificationResponseDTOList.add(authentificationResponseDTO);
        }
        return authentificationResponseDTOList;
    }

    private Customer getCustomer(Long id){
        CustomerServiceOuterClass.GetCustomerByIdRequest request =
                CustomerServiceOuterClass.GetCustomerByIdRequest.newBuilder()
                        .setCustomeId(id)
                        .build();
        CustomerServiceOuterClass.GetCustomerByIdResponse response =
                customerServiceBlockingStub.getCustomerById(request);
        return customerGRPCMapper.fromGRPCToCustomer(response.getCustomer());

    }




}
