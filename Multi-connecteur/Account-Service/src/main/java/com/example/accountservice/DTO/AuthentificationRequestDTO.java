package com.example.accountservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class AuthentificationRequestDTO {
    private String nom;
    private String email;
    private String motdepasse;
}
