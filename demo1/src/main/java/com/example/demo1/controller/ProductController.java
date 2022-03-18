package com.example.demo1.controller;

import com.example.demo1.dto.ProductDto;
import com.example.demo1.entity.CustomerEntity;
import com.example.demo1.entity.ProductEntity;
import com.example.demo1.repository.ProductRepository;
import com.example.demo1.request.CustomerRequest;
import com.example.demo1.request.ProductRequest;
import com.example.demo1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    @GetMapping
    public List<ProductEntity> get(){
        return productService.get();
    }

    @PostMapping
    public void save(@Valid @RequestBody ProductRequest product){
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody ProductRequest product,Long id){
        productService.update(product,id);
    }


}
