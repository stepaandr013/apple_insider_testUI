package com.example.apple_insider_testui.helpDesk;

import com.example.apple_insider_testui.core.BaseSeleniumTest;
import org.junit.Test;

public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void checkTicket(){
        String title = "Stepan Top Tester";
        String body = "Test Selenium Body 123123123";
        String email = "testSelenium@seleniumkek.md";

        MainPage mainPage = new MainPage();
        mainPage.createTicket(title, body, email);

    }

}
