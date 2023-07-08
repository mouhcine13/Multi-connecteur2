package com.example.accountservice.Service.RestApi;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;

import java.util.List;

public interface AuthentificationRestService {

    AuthentificationResponseDTO save(AuthentificationRequestDTO authentificationRequestDTO);
    AuthentificationResponseDTO findById(Long id);
    List<AuthentificationResponseDTO> findAll();
}
