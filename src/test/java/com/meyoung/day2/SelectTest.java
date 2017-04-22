package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/8.
 */
public class SelectTest {
    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开我们的测试界面
     * 下拉框选择 vivo
     * 第二次选择 huawei
     * 第三选择 iphone
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");

        WebElement selcetEl = driver.findElement(By.id("moreSelect"));
//      实例化 Select 类
        Select select = new Select(selcetEl);
//        通过 索引选择下拉框
        select.selectByIndex(2);
        Thread.sleep(3000);
//         通过 属性 Value 值来选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(3000);
//      通过 文本值值来选择下拉框
        select.selectByVisibleText("iphone");

    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
