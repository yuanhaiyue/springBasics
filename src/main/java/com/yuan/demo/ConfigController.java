package com.yuan.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Autowired
    SchoolConfig schoolConfig;


    @GetMapping({"/grade"})
    public String gradeClass(){
        return "年级: "+ schoolConfig.getGrade()+" 班级:" +schoolConfig.getClassNum();
    }

}
