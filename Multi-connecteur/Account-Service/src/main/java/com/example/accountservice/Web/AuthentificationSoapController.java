package com.example.accountservice.Web;

import com.example.accountservice.DTO.AuthentificationRequestDTO;
import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Model.Customer;
import com.example.accountservice.Service.Soap.AuthentificationSoapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authentification-soap")
public class AuthentificationSoapController {

    private AuthentificationSoapService authentificationSoapService;

    public AuthentificationSoapController(AuthentificationSoapService authentificationSoapService) {
        this.authentificationSoapService = authentificationSoapService;
    }

    @GetMapping("/")
    public List<AuthentificationResponseDTO> soapCustomers(){
        return authentificationSoapService.findAll();
    }

    @GetMapping("/{id}")
    public AuthentificationResponseDTO soapCustomerById(@PathVariable Long id){
        return authentificationSoapService.findById(id);
    }

    @PostMapping("/create")
    public AuthentificationResponseDTO create(@RequestBody AuthentificationRequestDTO authentificationRequestDTO){
        return authentificationSoapService.save(authentificationRequestDTO);
    }

}
