package com.example.apple_insider_testui.ApiTests;

public class Registration {
    private String email;
    private String password;

    public Registration(){
        super();
    }

    public Registration(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
