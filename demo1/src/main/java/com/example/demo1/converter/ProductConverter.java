package com.example.demo1.converter;

import com.example.demo1.dto.ProductDto;
import com.example.demo1.entity.ProductEntity;
import com.example.demo1.request.ProductRequest;

public class ProductConverter {
    public static ProductEntity toEntity(ProductRequest productDto){
        return ProductEntity.builder()
                .id(productDto.getId())
                .productName(productDto.getProductName())
                .qty(productDto.getQty())
                .price(productDto.getPrice())
                .build();

    }
    public static ProductDto toDto(ProductEntity product){
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .qty(product.getQty())
                .price(product.getPrice())
                .build();
    }
}
