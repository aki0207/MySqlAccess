package com.example.entity;

public class TUser {

    private Integer userId;

    private String userName;

    
    private String userPassword;

    
    private String userEmail;

    public Integer getUserId() {
        return userId;
    }

   
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

   
    public String getUserPassword() {
        return userPassword;
    }

    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    
    public String getUserEmail() {
        return userEmail;
    }

  
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}