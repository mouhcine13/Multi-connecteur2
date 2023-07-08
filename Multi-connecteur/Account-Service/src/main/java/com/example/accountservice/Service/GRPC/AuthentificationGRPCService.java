package com.example.accountservice.Service.GRPC;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;

import java.util.List;

public interface AuthentificationGRPCService {

    AuthentificationResponseDTO save(AuthentificationRequestDTO authentificationRequestDTO);
    AuthentificationResponseDTO findById(Long id);
    List<AuthentificationResponseDTO> findAll();
}
