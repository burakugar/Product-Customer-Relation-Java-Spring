package com.example.demo1.entity;

import lombok.*;

import javax.persistence.*;
// customer not found exception
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // annotation defines that a class can be mapped to a table. And that is it, it is just a marker, like for example Serializable interface.
@Table(name="product")
public class ProductEntity {
    @Id
    private Long id;
    private String productName;
    private Integer qty;
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
