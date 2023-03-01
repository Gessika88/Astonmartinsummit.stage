package com.runmylease.astonmartinsummitstage.util;

import com.runmylease.astonmartinsummitstage.driver.DriverSingleton;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.util.Set;

public class FrameUtil {

    public static void switchToFrame(By frameLocator) {
        CustomLogger.info("FrameUtil.switchToFrame(): " + frameLocator);
        DriverSingleton.getDriver().switchTo().frame(DriverSingleton.getDriver().findElement(frameLocator));
    }

    public static void leaveFrame() {
        CustomLogger.info("FrameUtil.leaveFrame()");
        DriverSingleton.getDriver().switchTo().defaultContent();
    }

    public static void switchToWindow(By windowLocator) {
        CustomLogger.info("FrameUtil.switchToWindow(): " + windowLocator);
        String parentWindow = DriverSingleton.getDriver().getWindowHandle();
        Set<String> handles = DriverSingleton.getDriver().getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                DriverSingleton.getDriver().switchTo().window(windowHandle);
            }
        }
    }

}