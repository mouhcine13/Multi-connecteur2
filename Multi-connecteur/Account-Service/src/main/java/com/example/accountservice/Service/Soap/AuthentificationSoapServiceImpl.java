package com.example.accountservice.Service.Soap;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Entity.Authentification;
import com.example.accountservice.Mappers.AuthentificationMapper;
import com.example.accountservice.Mappers.CustomerSOAPMapper;
import com.example.accountservice.Model.Customer;
import com.example.accountservice.Repository.AuthentificationRepository;
import com.example.customerservice.web.CustomerRequestDTO;
import com.example.customerservice.web.CustomerResponseDTO;
import com.example.customerservice.web.CustomerSoapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthentificationSoapServiceImpl implements AuthentificationSoapService {

    private AuthentificationRepository authentificationRepository;
    private CustomerSoapService customerSoapService;
    private CustomerSOAPMapper customerSOAPMapper;
    private AuthentificationMapper authentificationMapper;

    public AuthentificationSoapServiceImpl(AuthentificationRepository authentificationRepository, CustomerSoapService customerSoapService, CustomerSOAPMapper customerSOAPMapper, AuthentificationMapper authentificationMapper) {
        this.authentificationRepository = authentificationRepository;
        this.customerSoapService = customerSoapService;
        this.customerSOAPMapper = customerSOAPMapper;
        this.authentificationMapper = authentificationMapper;
    }

    @Override
    public AuthentificationResponseDTO findById(Long id) {
        Authentification authentification = authentificationRepository.findById(id).orElse(null);
        CustomerResponseDTO customerResponseDTO = customerSoapService.findById(id);
        Customer customer = customerSOAPMapper.fromSoapToCustomer(customerResponseDTO);
        AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(authentification,customer);
        return authentificationResponseDTO;
    }

    @Override
    public List<AuthentificationResponseDTO> findAll() {
        List<Authentification> authentificationList = authentificationRepository.findAll();
        List<AuthentificationResponseDTO> authentificationResponseDTOList = new ArrayList<>();
        for (Authentification index : authentificationList){
            CustomerResponseDTO customerResponseDTO = customerSoapService.findById(index.getId_Customer());
            Customer customer = customerSOAPMapper.fromSoapToCustomer(customerResponseDTO);
            AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(index,customer);
            authentificationResponseDTOList.add(authentificationResponseDTO);
        }
        return authentificationResponseDTOList;
    }

    @Override
    public AuthentificationResponseDTO save(AuthentificationRequestDTO authentificationRequestDTO) {

        CustomerRequestDTO customerRequestDTO = customerSOAPMapper.fromAuthentificationToRequest(authentificationRequestDTO);
        CustomerResponseDTO customerResponseDTO = customerSoapService.save(customerRequestDTO);
        Authentification authentification = authentificationMapper.fromRequestToAuthentification(authentificationRequestDTO);
        authentification.setId_Customer(customerResponseDTO.getId());
        Authentification authentification_saved = authentificationRepository.save(authentification);
        Customer customer = customerSOAPMapper.fromSoapToCustomer(customerResponseDTO);
        AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(authentification_saved,customer);
        return authentificationResponseDTO;
    }
}
