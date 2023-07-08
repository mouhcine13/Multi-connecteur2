package com.example.accountservice.Service.GraphQL;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Entity.Authentification;
import com.example.accountservice.Mappers.AuthentificationMapper;
import com.example.accountservice.Model.Customer;
import com.example.accountservice.Repository.AuthentificationRepository;
import com.example.accountservice.Rest.GraphQL.CustomerGraphQl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class AuthentificationGraphServiceImpl implements AuthentificationGraphService {

    private CustomerGraphQl customerGraphQl;
    private AuthentificationRepository authentificationRepository;
    private AuthentificationMapper authentificationMapper;

    public AuthentificationGraphServiceImpl(CustomerGraphQl customerGraphQl, AuthentificationRepository authentificationRepository, AuthentificationMapper authentificationMapper) {
        this.customerGraphQl = customerGraphQl;
        this.authentificationRepository = authentificationRepository;
        this.authentificationMapper = authentificationMapper;
    }

    @Override
    public AuthentificationResponseDTO save(AuthentificationRequestDTO authentificationRequestDTO) {
        return null;
    }

    @Override
    public AuthentificationResponseDTO findById(Long id) {
        Authentification authentification = authentificationRepository.findById(id).orElse(null);
        Customer customer = customerGraphQl.findById(authentification.getId_Customer());
        AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(authentification,customer);
        return authentificationResponseDTO;
    }

    @Override
    public List<AuthentificationResponseDTO> findAll() {
        List<AuthentificationResponseDTO> authentificationResponseDTOList = new ArrayList<>();
        List<Authentification> authentificationList = authentificationRepository.findAll();

        for (Authentification index : authentificationList){
            Customer customer = customerGraphQl.findById(index.getId_Customer());
            AuthentificationResponseDTO authentificationResponseDTO = authentificationMapper.fromAuthentificationToResponse(index,customer);
            authentificationResponseDTOList.add(authentificationResponseDTO);
        }
        return authentificationResponseDTOList;
    }
}
