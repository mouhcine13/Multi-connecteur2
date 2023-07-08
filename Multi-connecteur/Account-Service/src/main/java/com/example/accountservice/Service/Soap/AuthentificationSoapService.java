package com.example.accountservice.Service.Soap;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Entity.Authentification;

import java.util.List;

public interface AuthentificationSoapService {

    AuthentificationResponseDTO findById(Long id);
    List<AuthentificationResponseDTO> findAll();
    AuthentificationResponseDTO save(AuthentificationRequestDTO authentificationRequestDTO);
}
