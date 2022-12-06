package com.airbnbselenidetest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.*;

public class AuthPopUpHandle {

    @Test
    public void authPopTest() throws InterruptedException, MalformedURLException {

        //open("https://the-internet.herokuapp.com/basic_auth");
        //open("https://the-internet.herokuapp.com/basic_auth", "", "admin", "admin");

        System.setProperty("selenide.browser", "edge");

        open(new URL("https://the-internet.herokuapp.com/basic_auth"), "", "admin", "admin");
        Thread.sleep(5000);
        String text = $(By.cssSelector("div.example")).getText();
        System.out.println("text = " + text);
        Assert.assertTrue(text.contains("Congratulations"));

    }
}
