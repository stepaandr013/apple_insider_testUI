package com.example.apple_insider_testui;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection articleTitles = $$x("//h2//a");

    public String getHrefFromFirstArticle(){
        return articleTitles.first().getAttribute("href");
    }

}
