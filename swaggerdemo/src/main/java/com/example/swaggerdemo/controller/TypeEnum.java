package com.example.swaggerdemo.controller;

public enum TypeEnum {
    BOOK("book"),
    FOOD("food"),
    OTHER("other");
    private String type;
    TypeEnum(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
}