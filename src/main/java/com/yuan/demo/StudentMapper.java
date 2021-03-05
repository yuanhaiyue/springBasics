package com.yuan.demo;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from students where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name")
    })
    Student findById(Integer id);
}
