package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/3/25.
 */
public class TestNGDemo02 {

//    校验 a == a;

    /**
     * 假如我用A账号B密码登陆
     * 那么我登陆成功
     * <p>
     * 我打开XXX页面，点击XXX删除，那么我删除成功
     */
    @Test
    public void assertEqualTest() {
        String a = "asdf";
        String b = "asdf";
        System.out.println("登陆");
        Assert.assertEquals(a, b, "校验登陆成功");
        Assert.assertEquals(a, b, "用户名是否OK");

    }

    @Test
    public void assertNotEqualTest() throws InterruptedException {
        Thread.sleep(10000);
        int a = 1;
        int b = 1;
        Assert.assertNotEquals(a, b);
    }

    @Test
    public void assertNullTest() {
        String a = "aa";
        Assert.assertNull(a);
    }

    @Test
    public void assertNotNullTest() {
        String a = null;
        Assert.assertNotNull(a);
    }

    @Test
    public void a(){
        Boolean a = true;
        Assert.assertTrue(a);
    }

}
