package com.meyoung.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/15.
 */
public class JSTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void exJS() throws InterruptedException {
       driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"maxlength\",\"1111111\")");
        Thread.sleep(5000);
    }


    @AfterMethod
    public void closed() {
        driver.quit();
    }

}
