package com.example.apple_insider_testui.helpDesk;

import com.example.apple_insider_testui.core.BaseSeleniumPage;
import com.example.apple_insider_testui.readProperties.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    
    @FindBy(xpath = "//select[@id='id_queue']")
    private WebElement queueList;

    @FindBy(xpath = "//select[@id='id_queue']//option[@value='1']")
    private WebElement queueValue;

    @FindBy(id = "id_title")
    private WebElement title;

    @FindBy(id = "id_body")
    private WebElement body;

    @FindBy(id = "id_due_date")
    private WebElement dateField;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td[a=26]")
    private WebElement dateValue;

    @FindBy(id = "id_submitter_email")
    private WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "userDropdown")
    private WebElement loginButton;

    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage createTicket(String titleValue, String bodyValue, String emailValue){
        queueList.click();
        queueValue.click();
        title.sendKeys(titleValue);
        body.sendKeys(bodyValue);
        dateField.click();
        dateValue.click();
        email.sendKeys(emailValue);
        submitButton.click();

        return this;
    }

    public LoginPage openLoginPage(){
        loginButton.click();
        return new LoginPage();
    }

}
