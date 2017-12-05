package com.example.examplespringdatarest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Data
@XmlRootElement
public class User extends AbstractEntity {

    private String username;
    private String tel;
}
