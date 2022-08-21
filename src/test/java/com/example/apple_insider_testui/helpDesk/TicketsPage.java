package com.example.apple_insider_testui.helpDesk;

import com.example.apple_insider_testui.core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketsPage extends BaseSeleniumPage {

    @FindBy(id = "search_query")
    private WebElement searchQuery;

    @FindBy(xpath = "//div[@class='tickettitle']")
    private WebElement title;

    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    public TicketPage findTicket(String str){
        searchQuery.sendKeys(str, Keys.ENTER);
        title.click();
        return new TicketPage();
    }

}
