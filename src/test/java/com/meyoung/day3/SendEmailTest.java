package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/15.
 */
public class SendEmailTest {
    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }

    @Test
    public void sendEmail() {
        LoginTest.login(driver, "meyoungtester", "meyoung123");

//        点击 写信按钮
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("meyoungtester@163.com");
//      定位主题文本框 并输入文本
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("这个是主题");
//      上传文件
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\Administrator\\Pictures\\timg (3).jpg");
//        定位 iframe
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("这是个内容");
//    driver控制权转交回页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']")).click();

        Boolean bl = driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bl);

    }



    @Test()
    public void sendEmailTestCase() {
        LoginTest.login(driver, "user", "pwd");
//        SendEmailTest.sendEmail("title", "fujian", "wenjian");
        Assert.assertEquals(1, 1);
    }
}
