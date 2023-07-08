package com.example.accountservice.Web;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Service.RestApi.AuthentificationRestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    private AuthentificationRestService authentificationService;

    public AuthentificationController(AuthentificationRestService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping("/create")
    public AuthentificationResponseDTO save(@RequestBody AuthentificationRequestDTO authentificationRequestDTO){
        return authentificationService.save(authentificationRequestDTO);
    }

    @GetMapping("/{id}")
    public AuthentificationResponseDTO findById(@PathVariable Long id){
        return authentificationService.findById(id);
    }

    @GetMapping("/")
    public List<AuthentificationResponseDTO> findAll(){
        return authentificationService.findAll();
    }
}
