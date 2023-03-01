package com.runmylease.astonmartinsummitstage.util;

import com.runmylease.astonmartinsummitstage.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtil {

    public static void pageScrollDown(By locator) {
        CustomLogger.info("JSUtil.pageScrollDown(By locator)");
        WebElement element = DriverSingleton.getDriver().findElement(locator);
        ((JavascriptExecutor) DriverSingleton.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

