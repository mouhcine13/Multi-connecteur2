package com.example.accountservice.Mappers;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Entity.Authentification;
import com.example.accountservice.Model.Customer;

public interface AuthentificationMapper {

    Authentification fromRequestToAuthentification(AuthentificationRequestDTO authentificationRequestDTO);
    AuthentificationResponseDTO fromAuthentificationToResponse(Authentification authentification, Customer customer);
}
