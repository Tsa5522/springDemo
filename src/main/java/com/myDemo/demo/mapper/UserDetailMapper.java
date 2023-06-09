package com.myDemo.demo.mapper;

import com.myDemo.demo.entity.User;
import com.myDemo.demo.entity.UserDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
//@Repository
public interface UserDetailMapper {
//    @Select("SELECT * FROM users WHERE userName = #{userName}")
    User findUserByName(String userName);

//    @Insert("INSERT INTO users(userName, password) VALUES(#{userName}, #{password})")
    void insert(User user);
}
