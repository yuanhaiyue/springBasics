package com.yuan.demo;



import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data

public class User {


    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String name;
    private String sex;
    @Min(value = 0,message = "年龄不能小于零")
    @Max(value = 120,message = "你活不了这么久")
    private Integer age;
    private String address;
    private Date birthday;
    private String email;
    private String phone;


}
