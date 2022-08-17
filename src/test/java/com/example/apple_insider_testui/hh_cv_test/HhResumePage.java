package com.example.apple_insider_testui.hh_cv_test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {
    private final SelenideElement gender = $x("//span[@data-qa=\"resume-personal-gender\"]");
    private final SelenideElement age = $x("//span[@data-qa=\"resume-personal-age\"]/span");
    private final SelenideElement city = $x("//span[@data-qa=\"resume-personal-address\"]");
    private final SelenideElement liveData = $x("//span[@data-qa=\"resume-personal-address\"]/ancestor::p");
    private final SelenideElement phoneNumberApruve = $x("//span[@class=\"bloko-icon bloko-icon_done bloko-icon_initial-secondary\"]");

    public static String GENDER = "gender";
    public static String AGE = "age";
    public static String CITY = "city";
    public static String CONFIRMED_PHONE_NUMBER = "apruved_number";
    public static String READY_TO_RELOCATE = "ready_to_relocate";

    public HhResumePage(String url) {
        Selenide.open(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getGender(){
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }

    public int getAge(){
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    public String getCity(){
        return city.getText();
    }

    public boolean isReadyRelocate(){
        return !liveData.getText().split(", ")[1].contains("не готов");
    }

    public boolean isConfirmedNumber(){
        return phoneNumberApruve.isDisplayed();
    }

    public Map<String, Object> getAttributes(){
        return new HashMap<>(){{
            put(GENDER, getGender());
            put(AGE, getAge());
            put(CITY, getCity());
            put(CONFIRMED_PHONE_NUMBER, isConfirmedNumber());
            put(READY_TO_RELOCATE, isReadyRelocate());
        }};
    }

}
