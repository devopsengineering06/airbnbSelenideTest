package com.airbnbselenidetest;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class CloseBrowser {
    @Test
    public void closeBrowserTest() {
        open("https://opensource-demo.orangehrmlive.com");  //Parent - index 0
        System.out.println(title());

        $("html > body > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > a:nth-of-type(4) > svg")

                .click();  // Child - index 1

        switchTo().window(1);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(title());
        closeWindow();
        switchTo().window(0);
        System.out.println(title());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        closeWebDriver();
    }
}
