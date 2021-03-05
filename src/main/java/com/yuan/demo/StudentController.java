package com.yuan.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public String student(@RequestParam Integer num){
       Student student= studentService.findStudent(num);
       return student.toString();
    }

}
