package com.airbnbselenidetest;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class WebDriverRunnerTest {

    @Test
    public void myTest() {

        open("https://opensource-demo.orangehrmlive.com");

        WebDriverRunner.clearBrowserCache();
        System.out.println("WebDriverRunner.url() = " + WebDriverRunner.url());
//        if (WebDriverRunner.url().contains("orangehrmlive")) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//        }
        Assert.assertTrue(WebDriverRunner.url().contains("orangehrmlive"));

//   ----------------------     HTML source page i verir--------------------------------------
//        System.out.println("WebDriverRunner.source() = " + WebDriverRunner.source());


//      Seleniuma ait metodlar getWebDriver metodu çağrılarak kullanılabilir.
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("WebDriverRunner.isChrome() = " + WebDriverRunner.isChrome());

        if (WebDriverRunner.isChrome())
            System.out.println("click on button");

        WebDriverRunner.getAndCheckWebDriver();

        System.out.println("WebDriverRunner.supportsJavascript() = " + WebDriverRunner.supportsJavascript());

        List<File> fileList = WebDriverRunner.getBrowserDownloadsFolder().files();

        System.out.println(fileList.size());

        WebDriverRunner.closeWebDriver();


    }
}
