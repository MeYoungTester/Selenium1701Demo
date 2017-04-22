package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/8.
 */
public class AlertTest {
    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Alert按钮
     * 3.  在alert警告框点击确定按钮
     */

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
//        把控制权转交给 alert
        Alert alert = driver.switchTo().alert();
//        获取警告框的文本值
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }


    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Confirm按钮
     * 3. 在Confirm警告框点击取消按钮
     * 4. 再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
//        driver控制权转交给　alert
        Alert alert = driver.switchTo().alert();
//        点击取消
        alert.dismiss();
        Thread.sleep(3000);
//        点击确定
        alert.accept();
    }

    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Prompt按钮
     * 3. 在Prompt 弹窗中，输入“这个是Prompt”
     * 4.  点击确定
     * 5. 再次点击确定按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是Prompt");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        driver.quit();
    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
