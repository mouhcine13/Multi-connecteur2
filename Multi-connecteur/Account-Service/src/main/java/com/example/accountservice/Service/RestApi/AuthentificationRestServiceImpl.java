package com.example.accountservice.Service.RestApi;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Entity.Authentification;
import com.example.accountservice.Mappers.AuthentificationMapper;
import com.example.accountservice.Mappers.CustomerMapper;
import com.example.accountservice.Model.Customer;
import com.example.accountservice.Repository.AuthentificationRepository;
import com.example.accountservice.Rest.RestAPI.CustomerTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthentificationRestServiceImpl implements AuthentificationRestService {
    private CustomerTemplate customerTemplate;
    private CustomerMapper customerMapper;
    private AuthentificationMapper authentificationMapper;
    private AuthentificationRepository authentificationRepository;

    public AuthentificationRestServiceImpl(CustomerTemplate customerTemplate, CustomerMapper customerMapper, AuthentificationMapper authentificationMapper, AuthentificationRepository authentificationRepository) {
        this.customerTemplate = customerTemplate;
        this.customerMapper = customerMapper;
        this.authentificationMapper = authentificationMapper;
        this.authentificationRepository = authentificationRepository;
    }

    @Override
    public AuthentificationResponseDTO save(AuthentificationRequestDTO authentificationRequestDTO) {
        Customer customer = customerTemplate.save(customerMapper.fromRequestToCustomer(authentificationRequestDTO));
        Authentification authentification = authentificationMapper.fromRequestToAuthentification(authentificationRequestDTO);
        authentification.setMotdepasse(passwordEncoder().encode(authentification.getMotdepasse()));
        authentification.setId_Customer(customer.getId());
        Authentification authentification_saved = authentificationRepository.save(authentification);
        AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(authentification_saved,customer);
        return authentificationResponseDTO;
    }

    @Override
    public AuthentificationResponseDTO findById(Long id) {
        Authentification authentification = authentificationRepository.findById(id).orElse(null);
        Customer customer = customerTemplate.findById(authentification.getId_Customer());
        AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(authentification,customer);

        return authentificationResponseDTO;
    }

    @Override
    public List<AuthentificationResponseDTO> findAll() {
        List<Authentification> authentificationList = authentificationRepository.findAll();
        List<AuthentificationResponseDTO> authentificationResponseDTOList = new ArrayList<>();
        for (Authentification index : authentificationList){
            Customer customer = customerTemplate.findById(index.getId_Customer());
            AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(index,customer);
            authentificationResponseDTOList.add(authentificationResponseDTO);
        }

        return authentificationResponseDTOList;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
