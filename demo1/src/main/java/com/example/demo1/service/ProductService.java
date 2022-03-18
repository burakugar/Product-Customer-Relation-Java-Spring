package com.example.demo1.service;

import com.example.demo1.converter.CustomerConverter;
import com.example.demo1.converter.ProductConverter;
import com.example.demo1.dto.CustomerDto;
import com.example.demo1.dto.ProductDto;
import com.example.demo1.entity.ProductEntity;
import com.example.demo1.exception.CustomerNotFoundException;
import com.example.demo1.exception.ProductNotFoundException;
import com.example.demo1.repository.ProductRepository;
import com.example.demo1.request.CustomerRequest;
import com.example.demo1.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;
    public List<ProductEntity> get(){
        return productRepository.findAll();
    }
    public Optional<ProductEntity> getProduct(Long id){return productRepository.findById(id);};

    public void save(ProductRequest productRequest) {
        ProductEntity productEntity = ProductConverter.toEntity(productRequest);
        productRepository.save(productEntity);
    }

    public void delete(Long id){
        ProductEntity product = productRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        productRepository.delete(product);
    }

    public ProductDto get(Long productId) {
        return productRepository.findById(productId)
                .map(ProductConverter::toDto)
                .orElseThrow(CustomerNotFoundException::new); // customernotfound
    }

    public void update(ProductRequest product, Long id){
        productRepository.findById(id)
                .map(productEntity -> productRepository.save(ProductConverter.toEntity(product)))
                .map(ProductConverter::toDto)
                .orElseThrow(ProductNotFoundException::new);
    }
}
