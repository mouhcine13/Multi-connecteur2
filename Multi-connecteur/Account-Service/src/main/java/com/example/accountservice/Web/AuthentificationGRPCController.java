package com.example.accountservice.Web;

import com.example.accountservice.DTO.AuthentificationResponseDTO;
import com.example.accountservice.Model.Customer;
import com.example.accountservice.Service.GRPC.AuthentificationGRPCService;
import com.example.customerservice.stub.CustomerServiceOuterClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authentification-grpc")
public class AuthentificationGRPCController {

    private AuthentificationGRPCService authentificationGRPCService;

    public AuthentificationGRPCController(AuthentificationGRPCService authentificationGRPCService) {
        this.authentificationGRPCService = authentificationGRPCService;
    }


    @GetMapping("/")
    private List<AuthentificationResponseDTO> findAll(){
        return authentificationGRPCService.findAll();
    }

    @GetMapping("/{id}")
    public AuthentificationResponseDTO grpcCustomerById(@PathVariable Long id){
        return authentificationGRPCService.findById(id) ;
    }

}
