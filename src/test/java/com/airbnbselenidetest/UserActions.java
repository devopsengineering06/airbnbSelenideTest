package com.airbnbselenidetest;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserActions {

    @Test
    public void moveToElement() throws InterruptedException {
        open("https://www.spicejet.com/");
        Thread.sleep(5000);
        SelenideElement addOn = $(By.xpath("//div[text()='Add-ons']"));

        actions().moveToElement(addOn).build().perform();

        SelenideElement visaServices = $(By.xpath("//div[text()='Visa Services']"));

        visaServices.click();

        Thread.sleep(5000);
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        open("https://jqueryui.com/droppable/");

        switchTo().frame($(By.xpath("//iframe[@class='demo-frame']")));
        SelenideElement sourceEle = $(By.id("draggable"));
        SelenideElement targetEle = $(By.id("droppable"));

//        actions()
//                .clickAndHold(sourceEle)
//                .moveToElement(targetEle)
//                .release()
//                .build()
//                .perform();
        actions().dragAndDrop(sourceEle, targetEle).build().perform();

    }

    @Test
    public void rightClickTest() throws InterruptedException {
        open("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        SelenideElement rightCick = $(By.xpath("//span[text()='right click me']"));

        //actions().contextClick(rightCick).build().perform();
        actions().contextClick().build().perform();
        Thread.sleep(5000);

    }
}
