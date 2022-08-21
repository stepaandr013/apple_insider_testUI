package com.example.apple_insider_testui.kuCoinApi;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class StreamApiExamples {

    public List<TickerData> getTickers(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.kucoin.com/api/v1/market/allTickers")
                .then().log().body()
                .extract().jsonPath().getList("data.ticker", TickerData.class);
    }

    @Test
    public void checkCrypto(){
        List<TickerData> usdTickers = getTickers().stream().filter(x->x.getSymbol().endsWith("USDT")).collect(Collectors.toList());
        Assert.assertTrue(usdTickers.stream().allMatch(x->x.getSymbol().endsWith("USDT")));
        int i = 5;
    }
}
