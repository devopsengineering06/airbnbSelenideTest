package com.airbnbselenidetest;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class NavigationConcepts {
    @Test
    public void navigateTest() {
        open("https://www.google.com.tr");
        System.out.println(title());

        open("https://www.amazon.com.tr");
        System.out.println(title());

        back();
        System.out.println(title());

        forward();
        System.out.println(title());

        back();
        System.out.println(title());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        refresh();
    }
}
