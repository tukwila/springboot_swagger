package com.example.swaggerdemo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("FilterConditionValue")
public class FilterConditionValue{

    @ApiModelProperty(name = "id",value = "id",required = true)
    private String id;
    @ApiModelProperty(name = "stu",value = "stu",required = true)
    private Student stu;
    @ApiModelProperty(name = "pro", value = "pro", required = true)
    private Product pro;

    public String getId(){
        return "ok";
    }
	public Student getStu() {
		return stu;
	}
    public Product getPro(){
        return pro;
    }

}