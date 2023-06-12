package com.myDemo.demo.mapper;

import com.myDemo.demo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDetailMapper {
//    @Select("SELECT * FROM users WHERE userName = #{userName}")
    User findUserByName(String userName);

//    @Insert("INSERT INTO users(userName, password) VALUES(#{userName}, #{password})")
    void insert(User user);

    void updatePassword(String userName, String password);


}
