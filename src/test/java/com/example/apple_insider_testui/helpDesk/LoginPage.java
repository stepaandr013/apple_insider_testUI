package com.example.apple_insider_testui.helpDesk;

import com.example.apple_insider_testui.core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(id = "username")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public TicketsPage auth(String loginValue, String passwordValue){
        login.sendKeys(loginValue);
        password.sendKeys(passwordValue, Keys.ENTER);

        return new TicketsPage();
    }
}
