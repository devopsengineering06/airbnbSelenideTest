package com.airbnbselenidetest;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class LaunchBrowser {

    @Test
    public void launchBrowserTest() {


//        ------------------------ 1. yol------------------------
        //Configuration.browser = "firefox";
        Configuration.browser = "chrome";
        Configuration.headless = true;
//        ------------------------ 2. yol------------------------
        //System.setProperty("selenide.browser","chrome");
        // mvn clean install -Dselenide.browser="chrome"       --> Jenkins  için yazılacak code

//        veya başka bir tarayıcı için test

        //System.setProperty("selenide.browser","firefox");
        // mvn clean install -Dselenide.browser="firefox"       --> Jenkins  için yazılacak code


        open("https://www.google.com.tr");
        $(By.name("q")).setValue("Naveen AutomationLabs");
        $(By.name("btnK")).click();
        $(By.id("logo")).shouldHave(Condition.appear);
        String header = $(By.xpath("//h3[text()='Welcome to Naveen AutomationLabs - naveen automationlabs']")).getText();
        System.out.println("header = " + header);
        Assert.assertEquals(header, "Welcome to Naveen AutomationLabs - naveen automationlabs");

    }
}
