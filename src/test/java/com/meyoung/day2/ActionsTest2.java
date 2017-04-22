package com.meyoung.day2;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


/**
 * Created by Administrator on 2017/4/8.
 */
public class ActionsTest2 {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    /**
     * 打开百度页面
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClickTest() {
        driver.get("http://www.baidu.com");

        WebElement buttonBaidu = driver.findElement(By.id("su"));
//      实例化 Actions
        Actions actions = new Actions(driver);
//      在百度一下按钮 右键
        actions.contextClick(buttonBaidu).perform();
    }

    /**
     * 打开百度页面
     * 双击百度一下按钮
     */
    @Test
    public void doubleClickTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();
    }

    /**
     * 打开测试页面
     * 鼠标移动到 action 按钮
     * 那么显示 hello world!
     */
    @Test
    public void move() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();

        Assert.assertEquals(hello, "Hello World!");
    }

    @Test
    public void testDrop() throws InterruptedException {
        driver.get("file:///C:/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 500, 500).perform();
        Thread.sleep(3000);
    }

    @Test
    public void dropTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/dragAndDrop.html");

        WebElement el1 = driver.findElement(By.id("drag"));
        WebElement el2 = driver.findElement(By.xpath("/html/body/h1"));
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.clickAndHold(el1)
                .moveToElement(el2)
                .release(el1)
                .perform();
        Thread.sleep(5000);
    }

    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(2))
                .keyUp(Keys.CONTROL)
                .perform();
        Thread.sleep(5000);
    }

    @Test
    public void savaHtml() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS = (int)new Character('A');
        System.out.println(keyS);
        robot.keyPress(87);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.id("load"))
                .sendKeys("C:\\Users\\Administrator\\Pictures\\timg (3).jpg");

        Thread.sleep(5000);
    }



}
