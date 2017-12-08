package com.example.examplespringdatarest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Data
@XmlRootElement
public class User extends AbstractEntity {

    @ApiModelProperty(notes = "用户名")
    private String username;

    @ApiModelProperty(notes = "电话号码")
    private String tel;
}
