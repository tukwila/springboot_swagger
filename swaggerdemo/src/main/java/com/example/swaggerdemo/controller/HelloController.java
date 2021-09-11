package com.example.swaggerdemo.controller;

import java.sql.Date;
import java.util.UUID;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaTray;
import javax.servlet.http.HttpServletRequest;

import com.google.common.net.MediaType;

import org.aspectj.util.TypeSafeEnum;
import org.hibernate.type.TrueFalseType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.result.FlashAttributeResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import aj.org.objectweb.asm.Type;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/* 类注解 */
@Api(value = "desc of class")
@RequestMapping("/hello")
@RestController
public class HelloController {

    /* 方法注解 */
    @ApiOperation(value = "desc of method", notes = "")
    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    @ApiImplicitParam(name = "id",value = "desc of param",required = true,paramType = "query",dataType = "string")
    public Object hello(@RequestParam final String id) {
        return "Hello " + id + "!";
    }

    @ApiOperation(value = "test startdate", notes = "")
    @RequestMapping(path = "/getStartDate",method = RequestMethod.GET)
    @ApiImplicitParam(name = "startdate",value = "start date",required = false,paramType = "query",dataType = "date")
    public Object getStartDate(@RequestParam final Date startdate) {
        return "Hello " + startdate + "!";
    }

    //upload file or picture
    @ApiOperation(value="upload file or picture")
    @RequestMapping(value="/uploadFile", method = RequestMethod.POST)
    @ApiImplicitParam(name = "file", value="上传文件", required = false, paramType = "form", dataType = "__file")
    public Object uploadFile(@RequestPart final MultipartFile file){
        return "upload file ok";
    }

    //选择文件上传到服务器
    @ApiOperation("选择文件用multipart方式上传服务器")
    @RequestMapping(path="/uploadFilebyMultipart", consumes = "multipart/*", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
    //@ApiImplicitParam(name = "uploadFile", value="上传的文件", required = false)
    public String uploadFilebyMultipart(@ApiParam(value = "上传的文件", required = false) MultipartFile uploadFile, HttpServletRequest request){
        //生成随机fileKey
        String fileKey = UUID.randomUUID().toString();
        String fileName = uploadFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.indexOf("."));
        if (".png".equals(suffix) || ".jpg".equals(suffix)){
            return "uploadFilebyMultipart pass";
        }else{
            return "upload png/jpg";
        }
    }


    //enum tpye
    @ApiOperation(value = "enum")
    @RequestMapping(path="/getEnum", method = RequestMethod.GET)
    @ApiImplicitParam(name = "enumTest", value = "enum test", required = false, paramType = "query", allowableValues = "Male, Female, None")
    public Object getEnum(@RequestParam final String enumTest){
        return "enum "+ enumTest + " ok";
    }

    @ApiOperation(value = "type enum test")
    @RequestMapping(path="/findByType", method = RequestMethod.GET)
    @ApiImplicitParam(name = "type", value = "type test", required = false, paramType = "query")
    //object include enum
    public Product findByType(final TypeEnum type){
        if(TypeEnum.BOOK.getType().equals(type)){
            return new Product(49.9, "Think in Java", "book");
        }
        return null;
    }

    @ApiOperation(value = "test int", notes = "")
    @RequestMapping(path = "/getInt",method = RequestMethod.GET)
    @ApiImplicitParam(name = "password",value = "password",required = true,paramType = "query",dataType = "int")
    public Object getInt(@RequestParam Integer password) {
        return password + " is " + getType(password);
    }

    @ApiOperation(value = "test float", notes = "")
    @RequestMapping(path = "/getPriceInFloat",method = RequestMethod.GET)
    @ApiImplicitParam(name = "price",value = "price",required = true,paramType = "query",dataType = "float")
    public Object getPriceInFloat(@RequestParam Float price) {
        return price + " is " + getType(price);
    }

    @ApiOperation(value = "test double", notes = "")
    @RequestMapping(path = "/getPriceInDouble",method = RequestMethod.GET)
    @ApiImplicitParam(name = "price",value = "price",required = true,paramType = "query",dataType = "double")
    public Object getPriceInDouble(@RequestParam Double price) {
        return price + " is " + getType(price);
    }

    private static String getType(Object a) {
        return a.getClass().toString();
    }

    @ApiOperation(value = "test header", notes = "")
    @RequestMapping(path = "/testHeader",method = RequestMethod.GET)
    @ApiImplicitParam(name = "headerId",value = "test header",required = false,paramType = "header",dataType = "int")
    public Object hello(@RequestHeader Integer headerId) {
        return "Hello header " + headerId + "!";
    }
}
