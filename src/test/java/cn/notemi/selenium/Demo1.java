package cn.notemi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Title：Demo1
 *
 * @author Flicker
 * @create 2018/4/20 0020 10:47
 **/
public class Demo1 {
    @BeforeClass
    public void beforeAction() {
        System.out.println("用例前执行打印本句！");
        System.out.println("每条Test用例是互不相干的");
        System.out.println("用例开始执行…………");
    }

    @AfterClass
    public void afterAction(){
        System.out.println("用例结束后运行");
    }

    @Test
    public void actions() {
        //chrome driver
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //firefox driver
        //System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        driver.get("http://baidu.com");
        try {
            //页面等待
            Thread.sleep(3000);
            //定位输入框元素
            WebElement kwInput = driver.findElement(By.id("kw"));
            //在输入框输入文本
            kwInput.sendKeys("小米笔记");
            //定位按钮元素
            WebElement searchBtn = driver.findElement(By.id("su"));
            //点击按钮
            searchBtn.click();
            //页面等待
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭驱动
            driver.close();
        }
    }
}
