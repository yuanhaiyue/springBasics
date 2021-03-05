package com.yuan.demo;


import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lx")
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
