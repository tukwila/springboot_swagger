package com.example.swaggerdemo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("学生类")
public class Student {
        /**
         * 唯一标识id
         */
        //@ApiModelProperty("id")
        @ApiModelProperty(name = "id",value = "学号",required = true)
        private Integer id;
        /**
         * 姓名
         */
        //@ApiModelProperty("姓名")
        @ApiModelProperty(name = "name",value = "姓名",required = true)
        private String name;
        /**
         * 年龄
         */
        //@ApiModelProperty(value = "年龄")
        @ApiModelProperty(name = "age",value = "年龄",required = true)
        private Integer age;

        @ApiModelProperty(name = "grade",value = "年级",required = true)
        private Integer grade;

        public void setId(final int i) {
                this.id = i;
        }

        public void setAge(final Integer age) {
                this.age = age;
        }

        public void setName(final String name) {
                this.name = name;
        }

        public void setGrade(final Integer grade) {
                this.grade = grade;
        }

        public Integer getId() {
                return id;
        }

}