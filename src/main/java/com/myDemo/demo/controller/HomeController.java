package com.myDemo.demo.controller;

//import com.myDemo.demo.entity.User;
//import com.myDemo.demo.service.MyUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/userProfile")
    public String getUserpage(){
        return "userProfile";
    }

    @GetMapping("/homePage")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping({"/login", "/"})
    public String getLoginPage() {return "login";}

    @GetMapping("/loginFail")
    public String getLoginFail() {return "loginFail";}

    @GetMapping("/logout")
    public String getLogout() {return "logout";}

    @GetMapping("/perform_login")
    public String getLoginProcess() {return "performLogin";}

    @GetMapping("/register")
    public String getRegistration() {return "register";}

    @GetMapping("/userList")
    public String getUserList() {return "userTable";}
}
