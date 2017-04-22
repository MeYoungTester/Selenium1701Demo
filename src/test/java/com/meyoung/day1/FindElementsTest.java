package com.meyoung.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/3/25.
 */
public class FindElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度页面
     * 通过ID定位搜索文本框
     */
    @Test
    public void byIDTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.id("kw"));
    }

    /**
     * 打开百度页面
     * 通过name定位搜索文本框
     */
    @Test
    public void byNameTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.name("wd"));
    }

    /**
     * 打开百度页面
     * 通过class属性定位搜索文本框
     */
    @Test
    public void byClassTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.className("quickdelete"));
    }


    /**
     * 打开百度页面
     * 通过linkText定位搜索文本框
     */
    @Test
    public void byLinkTextTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.linkText("糯米"));
    }

    /**
     * 打开百度页面
     * 通过partialLinkText定位搜索文本框
     */
    @Test
    public void bypartialLinkTextTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.partialLinkText("糯"));
    }

    /**
     * 打开百度页面
     * 通过tagname定位搜索文本框
     */
    @Test
    public void byTagName() {
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }


    /**
     * 打开百度页面
     * 通过xpathe 百度一下按钮
     */
    @Test
    public void byXpath() {
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.xpath(".//*[@id='u1']/a[4]"));
        System.out.println(e1.getText());
    }

    /**
     * 打开百度页面
     * 通过xpathe 百度一下按钮
     */
    @Test
    public void byXpath02() {
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            System.out.println(text);
        }

    }

    /**
     * 打开百度页面
     * 通过css 百度图片
     */
    @Test
    public void byCSS() {
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.cssSelector("#lg>img"));
    }

    @AfterMethod
    public void colsedBrowser() {
        driver.quit();
    }

}
