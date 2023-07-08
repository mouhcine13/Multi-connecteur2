package com.example.accountservice.Mappers;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Entity.Authentification;
import com.example.accountservice.Model.Customer;
import org.springframework.stereotype.Component;

@Component
public class AuthentificationMapperImpl implements AuthentificationMapper {
    @Override
    public Authentification fromRequestToAuthentification(AuthentificationRequestDTO authentificationRequestDTO) {
        Authentification authentification = new Authentification();
        authentification.setEmail(authentificationRequestDTO.getEmail());
        authentification.setMotdepasse(authentificationRequestDTO.getMotdepasse());
        return authentification;
    }

    @Override
    public AuthentificationResponseDTO fromAuthentificationToResponse(Authentification authentification, Customer customer) {
        AuthentificationResponseDTO authentificationResponseDTO = new AuthentificationResponseDTO();
        authentificationResponseDTO.setId(authentification.getId());
        authentificationResponseDTO.setEmail(authentification.getEmail());
        authentificationResponseDTO.setMotdepasse(authentification.getMotdepasse());
        authentificationResponseDTO.setCustomer(customer);
        return authentificationResponseDTO;
    }
}
