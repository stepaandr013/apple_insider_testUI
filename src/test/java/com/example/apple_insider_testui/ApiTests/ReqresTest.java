package com.example.apple_insider_testui.ApiTests;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndId(){
        List<UserData> userData = given()
                .when()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

//        List<UserData> users = given()
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then() .log().all()
//                .extract().body().jsonPath().getList("data", UserData.class);

//        System.out.println(55555555);
        userData.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
    }

}
