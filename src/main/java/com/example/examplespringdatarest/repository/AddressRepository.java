package com.example.examplespringdatarest.repository;

import com.example.examplespringdatarest.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Long> {
}
