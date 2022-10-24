package com.example.project2;

public class User {
    String user_name; // user's name
    String user_pass; // user's password

    // Constructor for User
    public User(String name, String phone, String email, String password) {
        this.user_name = name;
        this.user_pass = password;
    }

    // Gets user ID
    public int getUserId() {

        return id;
    }

    // Sets UserID
    public void setUserId(int id) {

        this.id = id;
    }

    // Gets username
    public String getUsername() {

        return user_name;
    }

    // Sets username
    public void setUsername(String name) {

        this.user_name = name;
    }

    // Gets user password
    public String getUserPass() {

        return user_pass;
    }

    // Sets User Password
    public void setUserPass(String pass) {
        this.user_pass = pass;
    }
}