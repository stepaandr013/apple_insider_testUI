package com.example.apple_insider_testui.wikiTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.example.apple_insider_testui.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikiTest extends BaseTest {
    private final static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openHrefs(){
        Selenide.open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();

        hrefs.forEach(x-> links.add(x.getAttribute("href")));

//        links.forEach(Selenide::open);

//        for (int i = 0; i < hrefs.size(); i++){
//            String hrefURL = hrefs.get(i).getAttribute("href");
//            Selenide.open(hrefURL);
//            String currentURL = WebDriverRunner.getWebDriver().getCurrentUrl();
//
//            Assert.assertEquals(hrefURL, currentURL);
//        }

//        Random random = new Random();
//
//        while (links.size() > 0){
//            int randomNumber = random.nextInt(links.size());
//
//            Selenide.open(links.get(randomNumber));
//            links.remove(WebDriverRunner.getWebDriver().getCurrentUrl());
//
//        }

        List<Integer> linksLength = hrefs.stream().map(x->x.getAttribute("href").length()).collect(Collectors.toList());

    }
}
