package com.example.swaggerdemo.controller;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("Product")
public class Product {
    @NotBlank
    @ApiModelProperty(name = "price",value = "price",required = true)
    private double price;
    @ApiModelProperty(name = "proName",value = "proName",required = true)
    private String proName;
    @ApiModelProperty(name = "type",value = "proType",required = true)
    private TypeEnum type;

    public Product(double x, String y, String z) {
		price = x;
        proName = y;
        type = z;
    }

    public String getName(String proName) {
        return "ok";
    }
    public String getPrice(Double price) {
        return "ok";
    }
    public String getType(TypeEnum type) {
        return "ok";
    }

    public void setName(final String proName){
        this.proName = proName;
    }
    public void setPrice(final Double price){
        this.price = price;
    }
    public void setType(final TypeEnum Type){
        this.type = Type;
    }

}