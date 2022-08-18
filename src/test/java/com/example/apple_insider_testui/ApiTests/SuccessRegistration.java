package com.example.apple_insider_testui.ApiTests;

public class SuccessRegistration {
    private Integer id;
    private String token;

    public SuccessRegistration(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessRegistration(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
