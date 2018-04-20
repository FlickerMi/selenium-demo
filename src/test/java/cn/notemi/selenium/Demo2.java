package cn.notemi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Title：Demo2
 *
 * @author Flicker
 * @create 2018/4/20 0020 10:47
 **/
public class Demo2 {
    @BeforeClass
    public void beforeClass() {
        System.out.println("用例前执行打印本句！");
        System.out.println("每条Test用例是互不相干的");
        System.out.println("用例开始执行…………");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("用例结束后运行");
    }
    @Test
    public void actions() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //打开禅道界面
        driver.get("http://www.zentao.net/user-login.html");
        //以下元素使用css格式 -cssSelector
        //输入账号
        driver.findElement(By.cssSelector("#account")).sendKeys("Flicker");
        //输入密码
        driver.findElement(By.cssSelector("#password")).sendKeys("12345678910");
        //点击登录
        driver.findElement(By.cssSelector("#submit")).click();
        try {
            //页面等待
            Thread.sleep(3000);
            //抓取成功登录后的用户名信息
            String text = driver.findElement(By.cssSelector("#siteNav > a:nth-child(4)")).getText();
            //断言-校验是否登录成功
            Assert.assertEquals(text,"张三");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭浏览器进程及驱动
        driver.close();
    }
}
