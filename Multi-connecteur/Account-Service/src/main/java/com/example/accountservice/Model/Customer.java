package com.example.accountservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Customer {
    private Long id;
    private String nom;
    private String email;
}
