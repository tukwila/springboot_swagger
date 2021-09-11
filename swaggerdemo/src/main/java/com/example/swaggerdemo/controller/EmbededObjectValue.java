package com.example.swaggerdemo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("EmbededObjectValue")
public class EmbededObjectValue {
    @ApiModelProperty(name = "id",value = "id",required = true)
    private String id;
    @ApiModelProperty(name = "animal",value = "animal",required = true)
    private Animal animal;

    public String getId(){
        return "ok";
    }
	public Animal getAnimal() {
		return animal;
	}

}