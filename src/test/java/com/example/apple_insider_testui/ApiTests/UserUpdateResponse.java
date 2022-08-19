package com.example.apple_insider_testui.ApiTests;

import java.util.Date;

public class UserUpdateResponse extends UserUpdateClass{
    private String updatedAt;
    public UserUpdateResponse(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public UserUpdateResponse() {
        super();
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
