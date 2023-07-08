package com.example.accountservice.Repository;

import com.example.accountservice.Entity.Authentification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthentificationRepository extends JpaRepository<Authentification,Long> {
}
