package com.yuan.demo;



import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data

public class User {

    @NotNull(groups = {Update.class},message = "更新操作 id 不能为空")
    @NotNull(groups = {Add.class},message = "添加操作是 id 为空")
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
