package com.myDemo.demo.entity;

public class UserDTO {
    private String userName;
    private String password;

    private String newPassword;

    public void setNewPassword(String newPassword){
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        password = newPassword;
        return newPassword;
    }

    // standard getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
