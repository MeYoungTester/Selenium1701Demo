package com.meyoung.day3;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/15.
 */
public class LoginTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }


    @DataProvider(name = "userlist")
    public Object[][] test1() {
        return new Object[][]{
                {"user1", "1231238"},
                {"user2", "asdfasfas"},
                {"user23", "sdfsf"}

        };
    }

    @Test(dataProvider = "userlist")
    public void loginSucess(String username,String pwd) {
        LoginTest.login(driver, username, pwd);
        //       显示等待
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String logout = driver.findElement(By.linkText("退出")).getText();
        if(username.equals("user23")&&pwd.equals("sdfsf")){
            Assert.assertEquals(logout, "退出");
        }else {
            Assert.assertEquals(logout, "asfasfafsa");
        }


    }

    @Test
    public void loginError() {
        LoginTest.login(driver, "meyoungtester", "meyoung1231111");
        //       显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));

        String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error, "帐号或密码错误");
    }


    public static void login(WebDriver driver, String email, String pwd) {
        //        driver 控制权转交
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
//        driver.findElement(By.id("asdfasd")).sendKeys(a);
        driver.findElement(By.id("dologin")).click();
        //
    }

    public static void loginPo(WebDriver driver, String email, String pwd) {
        //        driver 控制权转交
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
//        driver.findElement(By.id("asdfasd")).sendKeys(a);
        driver.findElement(LoginPage.loginButton).click();
        //
    }




    @AfterMethod
    public void closed() {
//        driver.quit();
    }
}
