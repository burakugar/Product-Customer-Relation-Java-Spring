package com.example.demo1.converter;

import com.example.demo1.dto.CustomerDto;
import com.example.demo1.entity.CustomerEntity;
import com.example.demo1.request.CustomerRequest;

public class CustomerConverter {
    public static CustomerEntity toEntity(CustomerRequest customerRequest) {
        return CustomerEntity.builder()
                .id(customerRequest.getId())
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .build();
    }
    public static CustomerDto toDto(CustomerEntity customer) {
        return CustomerDto.builder()
                .email(customer.getEmail())
                .gender(customer.getGender())
                .id(customer.getId())
                .name(customer.getName())
                .build();
    }

}
