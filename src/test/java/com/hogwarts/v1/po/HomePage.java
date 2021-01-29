package com.hogwarts.v1.po;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    public HomePage(){
        init();
    }

    void init(){
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platformName", "Android"); //指定测试平台
            cap.setCapability("deviceName", "emulator-5554"); //指定测试机的ID,通过adb命令adb devices获取
            cap.setCapability("platformVersion", "6.0.1");
            cap.setCapability("appPackage", "com.tencent.wework");
            cap.setCapability("appActivity", ".launch.WwMainActivity");
            cap.setCapability("noReset", true);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 点击进入通讯录
     * @return
     */
    public ContactPage contact(){
        //点击通讯录
        click(By.xpath("//*[@text='通讯录']"));
        return new ContactPage(driver);
    }
}
