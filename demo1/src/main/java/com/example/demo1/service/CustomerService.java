package com.example.demo1.service;

import com.example.demo1.converter.CustomerConverter;
import com.example.demo1.converter.ProductConverter;
import com.example.demo1.dto.CustomerDto;
import com.example.demo1.dto.ProductDto;
import com.example.demo1.entity.CustomerEntity;
import com.example.demo1.exception.CustomerNotFoundException;
import com.example.demo1.repository.CustomerRepository;
import com.example.demo1.request.CustomerRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerDto> getAll(Long page, Long size) {
        return customerRepository.findAll(PageRequest.of(page.intValue(), size.intValue()))
                .stream()
                .map(CustomerConverter::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto get(Long customerId) {
        return customerRepository.findById(customerId)
                .map(CustomerConverter::toDto)
                .orElseThrow(CustomerNotFoundException::new); // customernotfound
    }

    public void save(CustomerRequest customer) {
        CustomerEntity customerEntity = CustomerConverter.toEntity(customer);
        customerRepository.save(customerEntity);
    }

    public void delete(Long id){
        CustomerEntity customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        customerRepository.delete(customer);
    }
    // update
    public void update(CustomerRequest customer, Long id){
        customerRepository.findById(id)
                .map(customerEntity -> customerRepository.save(CustomerConverter.toEntity(customer)))
                .map(CustomerConverter::toDto)
                .orElseThrow(CustomerNotFoundException::new);
    }
}
