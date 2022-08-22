package com.example.apple_insider_testui.kuCoinApi;

public class TickerShort {
    private String name;
    private Float changeRate;

    public TickerShort(String name, Float changeRate) {
        this.name = name;
        this.changeRate = changeRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(Float changeRate) {
        this.changeRate = changeRate;
    }
}
