package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    @Insert("INSERT INTO users (username, salt, password, firstname, lastname) VALUES (#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insert(User user);
}
