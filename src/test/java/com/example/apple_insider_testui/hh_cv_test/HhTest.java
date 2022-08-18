package com.example.apple_insider_testui.hh_cv_test;

import com.example.apple_insider_testui.core.BaseTest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HhTest extends BaseTest {
    private final static String URL_CV = "https://hh.ru/applicant/resumes/view?resume=1edf0c93ff095811d20039ed1f6a3638497073";

    @Test
    public void checkAtributesHashMap(){
        HhResumePage hhResumePage = new HhResumePage(URL_CV);

        Map<String, Object> expectedAttribute = new HashMap<>();
        expectedAttribute.put(HhResumePage.GENDER, "М");
        expectedAttribute.put(HhResumePage.AGE, 26);
        expectedAttribute.put(HhResumePage.CITY, "Санкт-Петербург");
        expectedAttribute.put(HhResumePage.CONFIRMED_PHONE_NUMBER, true);
        expectedAttribute.put(HhResumePage.READY_TO_RELOCATE, false);

        Map<String, Object> actualAttribute = hhResumePage.getAttributes();

        Assert.assertEquals(expectedAttribute, actualAttribute);
    }

    @Test
    public void checkAtributesClass(){
        HhResumePage hhResumePage = new HhResumePage(URL_CV);
        Resume expectedAttribute = new Resume("М", 26, "Санкт-Петербург", true, false);
        Resume actualAttribute = new Resume(hhResumePage.getGender(), hhResumePage.getAge(), hhResumePage.getCity(), hhResumePage.isConfirmedNumber(),
                hhResumePage.isReadyRelocate());
        Assert.assertEquals(expectedAttribute.getAge(), actualAttribute.getAge());
        Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedAttribute, actualAttribute));
    }
}
