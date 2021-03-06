package com.yuan.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("testValiDated")
    public User testValiDated(@Validated User user){
        return user;
    }

    @PostMapping("/testValidated-add")
    public User testValidated_add(@Validated({Add.class}) User user){
        return user;
    }
    @PostMapping("/testValidated-update")
    public User testValidated_update(@Validated({Update.class}) User user){
        return user;
    }

}
