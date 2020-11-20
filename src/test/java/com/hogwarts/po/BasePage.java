package com.hogwarts.po;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
}
