package com.example.apple_insider_testui.helpDesk;

import com.example.apple_insider_testui.core.BaseSeleniumTest;
import com.example.apple_insider_testui.helpers.TestValues;
import com.example.apple_insider_testui.readProperties.ConfigProvider;
import org.junit.Assert;
import org.junit.Test;


import static com.example.apple_insider_testui.helpers.StringModifier.getUniqueString;

public class HelpDeskTest extends BaseSeleniumTest {

    @Test
    public void checkTicket(){
        String title = getUniqueString(TestValues.TEST_TITLE);

        TicketPage ticketPage = new MainPage()
                .createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
                .openLoginPage()
                .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD)
                .findTicket(title);

        System.out.println(ticketPage.test1());
        Assert.assertTrue(ticketPage.getTitle().contains(title));
        Assert.assertEquals(TestValues.TEST_EMAIL, ticketPage.getEmail());
        Assert.assertEquals(TestValues.TEST_BODY, ticketPage.getDescription());

    }

}
