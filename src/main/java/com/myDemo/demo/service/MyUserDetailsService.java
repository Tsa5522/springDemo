package com.myDemo.demo.service;

import com.myDemo.demo.entity.User;
import com.myDemo.demo.entity.UserDTO;
import com.myDemo.demo.mapper.UserDetailMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {
//public class MyUserDetailsService{
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

    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(0);
        user.setName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        userDetailMapper.insert(user);
        System.out.println("hellohellohellohellohellohello"+user.getUsername());
    }
    @PostConstruct
    public void init() {
        System.out.println("MyUserDetailsService is created!");
    }
}
