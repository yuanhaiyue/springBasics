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
    //多数据传入 转换为 TestJavaBeanParam实体类
    @PostMapping("/testJavaBeen")
    public TestJavaBeanParam testJavaBean(TestJavaBeanParam testJavaBeanParam){
        testJavaBeanParam.setStrTemp("OK");
        return testJavaBeanParam;
    }
    //json格式传入
    @PostMapping("/testJson")
    public TestJavaBeanParam testJson(@RequestBody TestJavaBeanParam testJavaBeanParam){
        testJavaBeanParam.setStrTemp("OK");
        return testJavaBeanParam;
    }


}
