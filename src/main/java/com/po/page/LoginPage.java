package com.po.page;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2017/4/22.
 */
public class LoginPage {
    //    定义 email文本框的定位方式
    public static By emailInput = By.name("email");
    //    定义 密码输入框的定位方式
    public static By pwdInput = By.name("password");
    //    定义 登录按钮的定位方式
    public static By loginButton = By.id("login");

    //    去注册
    public static By zhuceButton = By.id("changepage");
}
