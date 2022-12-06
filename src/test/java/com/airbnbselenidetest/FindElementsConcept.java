package com.airbnbselenidetest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FindElementsConcept {

    @Test
    public void elementsTest() {

        open("https://www.amazon.com/");
        ElementsCollection colls = $$(By.tagName("a"));
        System.out.println("colls = " + colls.size());

        for (SelenideElement e : colls) {
            //System.out.println("e = " + e);
            String text = e.getText();
            String href = e.getAttribute("href");
            // System.out.println("(text+href) = " + (text + "---------" + href));


        }

        //System.out.println("colls.shouldHave(CollectionCondition.sizeLessThan(10)) = " + colls.shouldHave(CollectionCondition.sizeLessThan(300)));
        //colls.forEach(e -> System.out.println(e.getText()));
        //colls.stream().filter(e -> !e.getText().isEmpty()).forEach(e -> System.out.println("e.getText() = " + e.getText()));
        colls.last(10).forEach(e -> System.out.println("e.getText() = " + e.getText()));

    }
}
