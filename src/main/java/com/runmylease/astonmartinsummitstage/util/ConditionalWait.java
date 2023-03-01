package com.runmylease.astonmartinsummitstage.util;

import com.runmylease.astonmartinsummitstage.base.BaseElement;
import com.runmylease.astonmartinsummitstage.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static com.runmylease.astonmartinsummitstage.util.ConfigManager.getWaitDurationInSeconds;

public class ConditionalWait {

    private static int seconds;

    static {
        seconds = getWaitDurationInSeconds();
    }

    private static Duration duration = Duration.ofSeconds(seconds);

    public static void waitToBeClickableByLocator(By locator) {
        CustomLogger.info("ConditionalWait.waitToBeClickableByLocator()");
        new WebDriverWait(DriverSingleton.getDriver(), duration).until(ExpectedConditions.elementToBeClickable(locator));
    }

//    public static void waitElementAppears(WebElement element, int waitTime) {
//        CustomLogger.info("ConditionalWait.waitElementAppears()");
//        new WebDriverWait(DriverSingleton.getDriver(), duration)
//                .until(ExpectedConditions.visibilityOf(element));
//
//    }

    public static void waitElementDisappears(BaseElement element) {
        CustomLogger.info("ConditionalWait.waitElementDisappears(BaseElement element)");
        new WebDriverWait(DriverSingleton.getDriver(), duration)
                .until(ExpectedConditions.invisibilityOfElementLocated(element.getLocator()));
    }

    public static Alert waitUntilAlertIsPresent() {
        CustomLogger.info("ConditionalWait.waitUntilAlertIsPresent()");
        return new WebDriverWait(DriverSingleton.getDriver(), duration).until((ExpectedConditions.alertIsPresent()));
    }
}
