package com.meyoung.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/8.
 */
public class ActionsTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
//        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();

        System.setProperty("phantomjs.binary.path", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\phantomjs.exe");
        driver = new PhantomJSDriver();
    }

    /**
     * 我要点击百度首页的新闻链接
     * 那么我打开了新闻页面
     */
    @Test
    public void clickTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
//        定位新闻链接
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
//        点击新闻链接
        newslink.click();
//        获取当前页面的URL
        String url = driver.getCurrentUrl();
//        校验当前页面是不是新闻页面
        Assert.assertEquals(url, "http://news.baidu.com/");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 点击百度一下进行搜索
     * 校验title是否等于“selenium_百度搜索”
     */
    @Test
    public void sendkeysTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
//        定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
//        搜索框输入 selenium
        keys.sendKeys("selenium");
//        定位百度一下按钮
        WebElement baiduButton = driver.findElement(By.id("su"));
//        点击
        baiduButton.click();
        Thread.sleep(3000);
//        获取页面title
        String title = driver.getTitle();
//        校验
        Assert.assertEquals(title, "selenium_百度搜索");
    }

    @Test
    public void clearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
//        定位百度搜索框
        WebElement keys = driver.findElement(By.id("kw"));
//        搜索框输入 selenium
        keys.sendKeys("selenium");
        Thread.sleep(3000);
//        情况文本框
        keys.clear();
        Thread.sleep(3000);
    }

    /**
     * 打开百度首页
     * 获取文本框的 tagname
     * 校验是否为 input
     */
    @Test
    public void getTegNameTest() {
        driver.get("http://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName, "input");
    }

    /**
     * 打开百度页面
     * 判断按钮显示的文本值为 百度一下
     */
    @Test
    public void getATest() {
        driver.get("http://www.baidu.com");
        String attributeValue = driver.findElement(By.id("su")).getAttribute("type");
        Assert.assertEquals(attributeValue, "submit");
    }

    /**
     * 打开百度首页
     * 判断是否显示百度一下按钮
     */
    @Test
    public void isDisplayedTest() {
        driver.get("http://www.baidu.com");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }


    /**
     * 打开百度首页
     * 获取 新闻文本
     */
    @Test
    public void getTextTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        String text1 = driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text1, "新闻");
    }

    /**
     * 打开测试页面
     * 判断Volvo单选框被选中
     */
    @Test
    public void idSelectTest() {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
//        点击
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面
     * 判断 sumbit 按钮处于未激活状态
     */
    @Test
    public void isEnabledTest() {
        driver.get("file:///C:/selenium_html/index.html");
        Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest() throws IOException {
        driver.get("http://www.baidu.com");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("D:\\test12.jpg"));
    }


    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
