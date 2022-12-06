package com.airbnbselenidetest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelectDropDownTest {

    @Test
    public void userActions() throws InterruptedException {
        open("https://www.orangehrm.com/orangehrm-30-day-trial/");

        //Select html tag :
        $(By.id("Form_getForm_Country")).selectOption(2);
        Thread.sleep(2000);
        $(By.id("Form_getForm_Country")).selectOption("Turkey");
        Thread.sleep(2000);
        $(By.id("Form_getForm_Country")).selectOptionByValue("Angola");
        Thread.sleep(2000);

        //without using select html tag :
        ElementsCollection coll = $$(By.cssSelector("#Form_getForm_Country option"));
        System.out.println("coll.size() = " + coll.size());

        for (SelenideElement e : coll) {
            String text = e.getText();
            if (text.equals("Turkey")) {
                System.out.println("text = " + text);
                e.click();
                break;
            }
        }


    }
}
