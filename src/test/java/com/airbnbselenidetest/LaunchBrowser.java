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
        //System.setProperty("webdriver.gecko.driver", "/c/Selenium/geckodriver");
        //Configuration.browser = "firefox";
        Configuration.browser = "chrome";
//  ------------------------      Tarayıcılar açılmadan test yapılsın-------------------
        Configuration.headless = true;
//        ------------------------ 2. yol------------------------
        //System.setProperty("selenide.browser","chrome");
        // mvn clean install -Dselenide.browser="chrome"       --> Jenkins  için yazılacak code
//        veya başka bir tarayıcı için test
        //System.setProperty("selenide.browser","firefox");
        // mvn clean install -Dselenide.browser="firefox"       --> Jenkins  için yazılacak code
//------------------------------------------------------------------------------------------------------------------------
        Configuration.baseUrl = "https://www.google.com.tr";
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = false;

        //Configuration.browserBinary = "/Users/devop/chromedriver";
        System.setProperty("selenide.browserBinary", "/c/Selenium/chromedriver");
        //System.setProperty("selenide.browserBinary", "/c/Selenium/geckodriver");

        open("/");
        $(By.name("q")).setValue("Naveen AutomationLabs");
        $(By.name("btnK")).click();
        $(By.id("logo")).shouldHave(Condition.appear);
        String header = $(By.xpath("//h3[text()='Welcome to Naveen AutomationLabs - naveen automationlabs']")).getText();
        System.out.println("header = " + header);
        Assert.assertEquals(header, "Welcome to Naveen AutomationLabs - naveen automationlabs");
    }
}
