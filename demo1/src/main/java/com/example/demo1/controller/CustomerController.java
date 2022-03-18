package com.example.demo1.controller;


import com.example.demo1.dto.CustomerDto;
import com.example.demo1.entity.CustomerEntity;
import com.example.demo1.request.CustomerRequest;
import com.example.demo1.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> get(){
       return customerService.getAll(10L,100L);
   }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //spring validator
    public void save(@Valid @RequestBody CustomerRequest customer){
         customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }

}
