package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Administrator on 2017/3/25.
 */
public class TestNGDemo1 {

    @BeforeTest
    public void beforeTest01() {
        System.out.println("这是BeforeTest注解");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("add");
        System.out.println("这是BeforeMethod注解");
    }

    @Test
    public void testCase2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Test注解,case2");
    }

    @Test
    public void testCase1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Test注解,case1");
    }

    @Test
    public void testCasea() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Test注解,case3");
        Assert.assertEquals(1,2);
    }

    @Test
    public void testCaseb() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Test注解,case3");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("这是@AfterMethod注解");

    }

    @AfterTest
    public void afterTest1() {
        System.out.println("这是@AfterTest注解");
    }

}
