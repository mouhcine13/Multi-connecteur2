package com.example.customerservice.Web;

import com.example.customerservice.DTO.CustomerRequestDTO;
import com.example.customerservice.DTO.CustomerResponseDTO;
import com.example.customerservice.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO customerResponseDTO = customerService.save(customerRequestDTO);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        CustomerResponseDTO customerResponseDTO = customerService.findById(id);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        List<CustomerResponseDTO> customerResponseDTOList = customerService.findAll();
        return ResponseEntity.ok(customerResponseDTOList);
    }
}
