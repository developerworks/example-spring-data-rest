package com.example.examplespringdatarest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Version;
import java.math.BigDecimal;

@Entity
@Data
public class Product extends AbstractEntity {

    @ApiModelProperty(notes = "产品ID")
    private String productId;

    @ApiModelProperty(notes = "产品描述")
    private String description;

    @ApiModelProperty(notes = "产品图片URL")
    private String imageUrl;

    @ApiModelProperty(notes = "产品价格", required = true)
    private BigDecimal price;

    @Version
    @ApiModelProperty(notes = "The auto-generated version of the product")
    private Integer version;

}
