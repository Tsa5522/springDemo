package com.myDemo.demo.service;

import com.myDemo.demo.entity.User;
import com.myDemo.demo.entity.UserDTO;
import com.myDemo.demo.mapper.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {
    private final UserDetailMapper userDetailMapper;

    @Autowired
    public MyUserDetailsService(UserDetailMapper userDetailMapper) {
        this.userDetailMapper = userDetailMapper;
    }


//    @Override
//    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = userDetailMapper.findUserByName(userName);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return user;
//    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDetailMapper.findUserByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        return user;
    }


    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(0);
        user.setUserName(userDTO.getUserName());
        user.setPassword(passwordEncoder().encode(userDTO.getPassword()));
        userDetailMapper.insert(user);
    }

    public void changeUserPassword(String username, String newPassword) {
        User user = userDetailMapper.findUserByName(username);
        if (user != null) {
            String encodedPassword = passwordEncoder().encode(newPassword);
            userDetailMapper.updatePassword(user.getUsername(), encodedPassword);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public List<User> findAllUsers() {
        return userDetailMapper.findAllUsers();
    }


}
