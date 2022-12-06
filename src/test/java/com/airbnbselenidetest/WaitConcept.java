package com.airbnbselenidetest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class WaitConcept {
    @Test
    public void waitTest() {
        Configuration.timeout = 5000;

        open("https://api.cogmento.com/register/");
        $(By.partialLinkText("Log in here")).click();

        SelenideElement email = $(By.name("email"));

        email.should(Condition.visible, Duration.ofSeconds(10)).sendKeys("DevOps");

        actions().moveToElement($(By.linkText("Sign Up"))).click().build().perform();
        SelenideElement checkBox = $(By.name("terms"));
        //checkBox.click();
        //checkBox.should(Condition.checked, Duration.ofSeconds(10));
        //checkBox.should(Condition.checked);
        checkBox.shouldNot(Condition.checked);
    }
}
