package com.example.customerservice;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.Service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new AuthentificationRequestDTO("Youssef","youssef@gmail","123"));
			customerService.save(new AuthentificationRequestDTO("mer","mer@gmail","123"));
			customerService.save(new AuthentificationRequestDTO("khalid","khalid@gmail","123"));
        };
    }
}
