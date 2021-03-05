package com.yuan.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {
    @Value("${school.grade}")
    Integer grade;
    @Value("${school.classNum}")
    Integer classNum;
    @GetMapping("/gradeClass")
    public String gradeClass(){
        return "年级:"+grade+"\r班级:"+classNum;
    }

}
