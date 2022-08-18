package com.example.apple_insider_testui.ApiTests;

public class UnSuccessRegistration {
    private String error;

    public UnSuccessRegistration(String email) {
        this.error = email;
    }

    public UnSuccessRegistration() {
        super();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
