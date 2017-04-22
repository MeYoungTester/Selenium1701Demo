package com.meyoung.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/22.
 */
public class DataDriverTest {

    @DataProvider(name = "loginUser")
    public Object[][] data1() {
        return new Object[][]{{"user1", "pwd1"},
                {"user2", "pwd2"},
                {"sfasf","fafda"}};
    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String user, String pwd) {
        System.out.println("user" + user);
        System.out.println("pwd" + pwd);
    }

}
