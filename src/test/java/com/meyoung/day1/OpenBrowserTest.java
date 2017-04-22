package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/3/25.
 */
public class OpenBrowserTest {

    @Test
    public void openFF(){
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openFF2(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }

    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }

    @Test
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();
    }


}
