package com.example.apple_insider_testui.ApiTests;

public class UserUpdateClass {
    private String name;
    private String job;

    public UserUpdateClass(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UserUpdateClass() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
