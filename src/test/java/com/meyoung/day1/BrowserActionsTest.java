package com.meyoung.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by Administrator on 2017/3/25.
 */
public class BrowserActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        //        设置chromedriver 路径
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
//        打开chrome
        driver = new ChromeDriver();
    }

    /**
     * 打开chrome 浏览器
     * 打开 百度首页
     * 等待5S
     * 关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
//        等待5S
        Thread.sleep(5000);
//        关闭浏览器
        driver.quit();
    }

    /**
     * 打开chrome 浏览器
     * 打开 百度首页
     * 等待3S
     * 后退
     * 等待3S
     * 关闭浏览器
     */

    @Test
    public void backTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
//        等待3S
        Thread.sleep(3000);
//        后退
        driver.navigate().back();
//        等待3S
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }

    /**
     * 打开chrome 浏览器
     * 打开 百度首页
     * 等待3S
     * 后退
     * 等待3S
     * 前进
     * 等待3S
     * 关闭浏览器
     */

    @Test
    public void forwardTest() throws InterruptedException {
//        打开百度首页
        driver.get("http://www.baidu.com");
//        等待3S
        Thread.sleep(3000);
//        后退
        driver.navigate().back();
//        等待3S
        Thread.sleep(3000);
//        前进
        driver.navigate().forward();
//        等待3S
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }

    /**
     * 打开chrome 浏览器
     * 打开 google首页
     * 等待3S
     * 刷新
     * 等待3S
     * 关闭浏览器
     */

    @Test
    public void refreshTest() throws InterruptedException {
        driver.get("https://www.google.com.hk/");
//        等待3S
        Thread.sleep(3000);
//        后退
        driver.navigate().refresh();
//        等待3S
        Thread.sleep(3000);
//        关闭浏览器
        driver.quit();
    }

    /**
     * 打开chrome 浏览器
     * 设置窗口大小  300*300
     * 等待3S
     * 最大化窗口
     * 等待3S
     * 关闭浏览器
     */
    @Test
    public void winTest() throws InterruptedException {
//        实例化Dimension 设置窗口大小
        Dimension dimension = new Dimension(300, 300);
        driver.manage().window().setSize(dimension);

        Thread.sleep(3000);
//        最大化
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();
    }


    /**
     * 打开chrome 浏览器
     * 打开 百度首页
     * 获取当前页面的 RUL
     * 校验当前页面URL是不是百度地址
     * 关闭浏览器
     */
    @Test
    public void getURLTest() {
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的URL是：" + url);
        Assert.assertEquals(url, "https://www.baidu.com/");
    }

    @AfterMethod
    public void closedBrowser() {
        driver.quit();
    }
}
