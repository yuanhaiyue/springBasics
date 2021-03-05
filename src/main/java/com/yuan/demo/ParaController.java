package com.yuan.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParaController {
    @GetMapping("/test")
    public String firstRequest(){
        return "one Spring boot";
    }

    @GetMapping("/req")
    public String requestPara(@RequestParam Integer num){
        return "para from request:"+num;
    }
    @GetMapping({"/para/{num}"})
    public String pathPara(@PathVariable Integer num){
        return "para from path: "+ num;
    }
    @GetMapping({"/multiUrl1","/multiUrl2"})
    public String multiUrl(@RequestParam Integer num){
        return "para from path: "+ num;
    }

    @GetMapping({"/required"})
    public String required(@RequestParam(required = false,defaultValue = "0") Integer num){
        return "para from path: "+ num;
    }



}
