package com.example.demo1.repository;

import com.example.demo1.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    List<CustomerEntity> findAllByCustomerId(Long customerId);
}
