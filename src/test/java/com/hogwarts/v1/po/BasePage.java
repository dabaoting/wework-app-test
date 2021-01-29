package com.hogwarts.v1.po;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    AndroidDriver driver;

    public BasePage() {}

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    void click(By by){
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(by)).click();
    }

    void sendKeys(By by, String text){
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(text);
    }

    String getText(By by){
        String text = new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(by)).getText();
        return text;
    }

    void scroll(){
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(width/2,height/3)).moveTo(PointOption.point(width/2,height)).perform();
    }
}
