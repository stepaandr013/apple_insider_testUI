package com.example.apple_insider_testui.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
