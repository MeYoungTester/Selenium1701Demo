package com.meyoung.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/4/15.
 */
public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //         创建一个 DesiredCapabilities 类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.105:4446/wd/hub"), dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @DataProvider(name = "data4")
    public Object[][] test1() {
        return new Object[][]{
                {"firefox", "http://192.168.1.105:8888"},
                {"chrome", "http://192.168.1.105:5556"}
        };
    }


    @Test(dataProvider = "data4")
    public void testGrid2(String browser, String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.contentEquals("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else if (browser.equals("chrome")) {
            dc = DesiredCapabilities.chrome();
        } else {
            System.out.println("error");
        }

        WebDriver driver = new RemoteWebDriver(new URL(url + "/wd/hub"), dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();

    }


    @Test(dataProvider = "data4")
    public void testGrid4(String browser, String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.contentEquals("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else if (browser.equals("chrome")) {
            dc = DesiredCapabilities.chrome();
        } else {
            System.out.println("error");
        }

        WebDriver driver = new RemoteWebDriver(new URL(url + "/wd/hub"), dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();

    }
}
