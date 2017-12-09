package com.example.examplespringdatarest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer extends AbstractEntity {
    /**
     * 客户名称
     */
    @Column
    private String name;

    /**
     * 客户地址清单
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void updateAddressAssociation() {
        for (Address address : this.addresses) {
            address.setCustomer(this);
        }
    }
}
