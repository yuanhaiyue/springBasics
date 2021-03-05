package com.yuan.demo;

import lombok.Data;

import java.util.Date;

@Data
public class TestJavaBeanParam {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private Date birthday;

    private TestJavaBeanParamTwo testJavaBeanParamTwo;
    private String strTemp;
}
