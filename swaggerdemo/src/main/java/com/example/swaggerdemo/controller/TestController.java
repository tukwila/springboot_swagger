package com.example.swaggerdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@RestController
@RequestMapping("/Test")
@Api("测试swagger接口")
public class TestController {

    @RequestMapping(path = "/getStudent",method = RequestMethod.GET)
    @ApiOperation("/根据学生id获取学生信息")
    @ApiImplicitParam(name = "id",value = "id",required = true,paramType = "query",dataType = "int")
    public Student getStudent(Integer id) {
        final Student student = new Student();
        student.setId(11);
        student.setAge(21);
        student.setName("全栈学习笔记");
        final Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(11, student);
        return studentMap.get(id);
    }

    @RequestMapping(path = "/findStudent/{id}/{name}",method = RequestMethod.GET)
    @ApiOperation("/查找学生")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "path", dataType = "String"),
        @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "int") })
    public Student getStudentFromPath(@PathVariable(value = "id") String id, @PathVariable(value = "name") String name) {
        final Student student = new Student();
        student.setId(11);
        student.setAge(21);
        student.setName("全栈学习笔记");
        final Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(11, student);
        return studentMap.get(id);
    }


    //配合header参数使用
    @ApiOperation("获取所有用户信息")
    @PostMapping(value = "findAll")
    public String findAll(){
       return "testheaderparam";
    }

    @RequestMapping(path = "/modifyStudent", method = RequestMethod.PATCH)
    @ApiOperation("/根据学生id获取学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, paramType = "query", dataType = "int") })
    public Student editStudent(@RequestParam final String name, @RequestParam final Integer age) {
        final Student student = new Student();
        student.setId(12);
        student.setName(name);
        student.setAge(age);
        return student;
    }

    @ApiOperation("/添加学生信息")
    @RequestMapping(path = "/addStudent", method = RequestMethod.POST)
    public Map<Integer, Student> AddStudent(@RequestBody Student student) {
        final Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(student.getId(), student);
        return studentMap;
    }
    
    @ApiOperation("testObject")
    @RequestMapping(path = "/testObject", method = RequestMethod.POST)
    @ApiImplicitParams({
        @ApiImplicitParam(name="param", value = "param", dataType = "FilterConditionValue", required = true, paramType = "body")
    })
    public boolean testObject(@RequestBody FilterConditionValue param){
        Object value = param.getStu();
        System.out.println(value.getClass());
        return true;
    }

    @ApiOperation("testEmbededObject")
    @RequestMapping(path = "/testEmbededObject", method = RequestMethod.POST)
    @ApiImplicitParams({
        @ApiImplicitParam(name="embededParam", value = "embededParam", dataType = "EmbededObjectValue", required = true, paramType = "body")
    })
    public boolean testEmbededObject(@RequestBody EmbededObjectValue embededParam){
        Object value = embededParam.getAnimal();
        System.out.println(value.getClass());
        return true;
    }

    @ApiOperation("complexObject")
    @RequestMapping(path = "/complexObject", method = RequestMethod.POST)
    @ApiImplicitParams({
        @ApiImplicitParam(name="embededParam", value = "embededParam", dataType = "EmbededObjectValue", required = true, paramType = "body"),
        @ApiImplicitParam(name="param", value = "param", dataType = "FilterConditionValue", required = true, paramType = "body")
    })
    public boolean complexObject(@RequestBody EmbededObjectValue embededParam, @RequestBody FilterConditionValue param){
        return true;
    }

    @ApiOperation("传递List参数")
    @RequestMapping(path="/testArray", method = RequestMethod.PUT)
    @ApiImplicitParam(name = "clientIds", value = "可被访问的clientId列表", paramType = "query", allowMultiple = true, dataType = "String", required = false)
    //public boolean testArray(@RequestParam(value = "clientIds") @ApiParam(value="可被访问的clientId列表") List<String> clientIds){
    public boolean testArray(@RequestParam List<String> clientIds){
        return true;
    }
}