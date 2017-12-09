package com.example.examplespringdatarest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Address extends AbstractEntity {

    /**
     * 街道
     */
    private String street;

    /**
     * 地址关联的客户
     */
    @ManyToOne
    private Customer customer;

}
