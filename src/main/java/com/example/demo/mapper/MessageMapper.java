package com.example.demo.mapper;

import com.example.demo.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM messages WHERE username = #{username}")
    Message getMessage(String username);

    @Select("SELECT * FROM messages")
    List<Message> getAllMessage();

    @Insert("INSERT INTO messages (username,messagetext) VALUES(#{username},#{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(Message message);
}
