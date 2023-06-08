package com.myDemo.demo.mapper;

import com.myDemo.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDetailMapper {
    @Select("SELECT * FROM users WHERE userName = #{userName}")
    User findUserByName(String userName);

    @Insert("INSERT INTO users(userName, password) VALUES(#{userName}, #{password})")
    void createUser(User user);
}
