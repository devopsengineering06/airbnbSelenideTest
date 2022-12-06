package com.airbnbselenidetest;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class JSAlertPopUpHandle {
    @Test
    public void alertTest() {
        open("https://mail.rediff.com/cgi-bin/login.cgi");
        $(By.name("proceed")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

      //-----------------Selenium metodlarıyla da yapılabilir--------------------
        //WebDriverRunner.getWebDriver().switchTo().alert();

        Alert alert = switchTo().alert();
        String text = alert.getText();
        System.out.println("text = " + text);

        Assert.assertEquals(text, "Please enter a valid user name");

        alert.accept();    // ok button
        //alert.dismiss();   // cancel the alert
        //alert.sendKeys("testing");
    }
}
