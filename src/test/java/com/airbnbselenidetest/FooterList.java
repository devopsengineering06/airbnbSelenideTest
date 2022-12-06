package com.airbnbselenidetest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class FooterList {
    @Test
    public void elementsTest() {

        open("https://www.freshworks.com/");
        ElementsCollection colls = $$(By.xpath("//footer//ul/li/a"));
        System.out.println("colls = " + colls.size());

//        for (SelenideElement coll : colls) {
//            System.out.println("coll.getText() = " + coll.getText());
//        }

//        colls.forEach(e -> System.out.println("e.getText() = " + e.getText()));
//        colls.last(10).stream().filter(e -> !e.getText().isEmpty()).forEach(e -> System.out.println("e.getText() = " + e.getText()));

//----------------------------Yukarıdaki foreach lere gerek yok-----------------------------------------
        List<String> footerTextList = colls.texts();
        System.out.println("footerTextList = " + footerTextList);

    }

}
