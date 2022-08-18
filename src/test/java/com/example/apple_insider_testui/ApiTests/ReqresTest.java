package com.example.apple_insider_testui.ApiTests;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndId(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        List<UserData> userData = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        userData.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        Assert.assertTrue(userData.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = userData.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = userData.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        for (int i = 0; i < avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void successRegistration(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Registration user = new Registration("eve.holt@reqres.in", "pistol");

        SuccessRegistration successRegistration = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegistration.class);

        Assert.assertNotNull(successRegistration.getId());
        Assert.assertNotNull(successRegistration.getToken());

        Assert.assertEquals(id, successRegistration.getId());
        Assert.assertEquals(token, successRegistration.getToken());
    }

    @Test
    public void unSuccessRegistration(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationError400());

        Registration user = new Registration("eve.holt@reqres.in", "");
        UnSuccessRegistration unSuccessRegistration = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessRegistration.class);

        Assert.assertEquals("Missing password", unSuccessRegistration.getError());
    }

    @Test
    public void checkSortData(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        List<YearDataSort> yearDataSorts = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", YearDataSort.class);

        List<Integer> years = yearDataSorts.stream().map(YearDataSort::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(sortedYears, years);

    }

}
