package com.capgemini.Model;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String roleKey;

    public User() {
    }

    public User(String userId, String userName, String password, String roleKey) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roleKey = roleKey;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleKey='" + roleKey + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }
}
