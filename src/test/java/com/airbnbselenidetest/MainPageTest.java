package com.airbnbselenidetest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {


    @Test
    public void googleSearchTest() {
        open("https://www.google.com.tr");
        $(By.name("q")).setValue("Naveen AutomationLabs");
        $(By.name("btnK")).click();
        $(By.id("logo")).shouldHave(Condition.appear);
        String header = $(By.xpath("//h3[text()='Welcome to Naveen AutomationLabs - naveen automationlabs']")).getText();
        System.out.println("header = " + header);
        Assert.assertEquals(header, "Welcome to Naveen AutomationLabs - naveen automationlabs");
        int headerCount = $$(By.cssSelector(".LC20lb.DKV0Md")).size();
        System.out.println("headerCount = " + headerCount);

        $$(By.cssSelector(".LC20lb.DKV0Md")).shouldHave(CollectionCondition.size(10));

    }

}
