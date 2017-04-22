package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/3/25.
 */
public class ClosedBrowserTest {

    @Test
    public void closedChrome() throws InterruptedException {
//        设置 chromedriver 路径
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
//        实例化 chromeDriver
        WebDriver driver = new ChromeDriver();
//        等待5S
        Thread.sleep(5000);
//        关闭当前窗前窗口
        driver.close();

    }


    @Test
    public void closedChrome1() throws InterruptedException {
//        设置 chromedriver 路径
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
//        实例化 chromeDriver
        WebDriver driver = new ChromeDriver();
//        等待5S
        Thread.sleep(5000);
//        完全退出浏览器
        driver.quit();

    }
}
