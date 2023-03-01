package com.runmylease.astonmartinsummitstage.util;

import com.runmylease.astonmartinsummitstage.driver.DriverSingleton;

public class BrowserUtil {

    public static void goToURL(String url) {
        CustomLogger.info("BrowserUtil.goToURL(): " + url);
        DriverSingleton.getDriver().navigate().to(url);
    }

    public static void closeCurrentTab() {
        CustomLogger.info("BrowserUtil.closeCurrentTab()");
        DriverSingleton.getDriver().close();
    }

    public static String getCurrentTabHandle() {
        CustomLogger.info("BrowserUtil.getWindowHandle()");
        return DriverSingleton.getDriver().getWindowHandle();
    }

    public static int getTabCount() {
        CustomLogger.info("BrowserUtil.getTabCount()");
        return DriverSingleton.getDriver().getWindowHandles().size();
    }

    public static void switchToOtherTab(String currentTabHandle) {
        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
            if(!currentTabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToNewTab() : true");
                DriverSingleton.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void switchToTab(String tabHandle) {
        for (String windowHandle : DriverSingleton.getDriver().getWindowHandles()) {
            if(tabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToTab()");
                DriverSingleton.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}

