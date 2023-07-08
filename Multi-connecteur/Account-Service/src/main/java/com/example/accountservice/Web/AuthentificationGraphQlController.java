package com.example.accountservice.Web;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Service.RestApi.AuthentificationRestService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthentificationGraphQlController {

    private AuthentificationRestService authentificationService;

    public AuthentificationGraphQlController(AuthentificationRestService authentificationService) {
        this.authentificationService = authentificationService;
    }
    @QueryMapping
    public List<AuthentificationResponseDTO> findAll(){
        return authentificationService.findAll();
    }

    @QueryMapping
    public AuthentificationResponseDTO findById(@Argument Long id){
        return authentificationService.findById(id);
    }

    @MutationMapping
    public AuthentificationResponseDTO save(@Argument AuthentificationRequestDTO authentificationRequestDTO){
        return authentificationService.save(authentificationRequestDTO);
    }
}
