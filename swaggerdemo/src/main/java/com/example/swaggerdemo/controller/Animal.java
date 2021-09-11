package com.example.swaggerdemo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("Animal")
public class Animal {
    @ApiModelProperty(name = "id",value = "编号",required = true)
    private Integer id;
    @ApiModelProperty(name = "animalName",value = "动物名称",required = true)
    private String animalName;
    @ApiModelProperty(name = "animalAge",value = "动物年龄",required = true)
    private Integer animalAge;
    @ApiModelProperty(name = "pro", value = "pro", required = true)
    private Product pro;

    public void setId(final int i) {
        this.id = i;
    }
    public void setName(final String animalName) {
        this.animalName = animalName;
    }
    public void setAge(final int animalAge) {
        this.animalAge = animalAge;
    }
    public void setPro(final Product pro) {
        this.pro = pro;
    }
}