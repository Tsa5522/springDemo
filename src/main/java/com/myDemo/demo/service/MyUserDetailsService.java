package com.myDemo.demo.service;

import com.myDemo.demo.entity.User;
import com.myDemo.demo.mapper.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserDetailMapper userDetailMapper;

    @Autowired
    public MyUserDetailsService(UserDetailMapper userDetailMapper) {
        this.userDetailMapper = userDetailMapper;
    }


    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDetailMapper.findUserByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        //System.out.println("Loaded user by username: " + user);  // Add this line
        return user;
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    public void createUser(String userName, String password) {
        User newUser = new User(0, userName, passwordEncoder().encode(password));
        userDetailMapper.createUser(newUser);
    }

}
