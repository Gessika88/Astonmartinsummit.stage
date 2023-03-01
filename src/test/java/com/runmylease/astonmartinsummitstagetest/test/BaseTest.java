package com.runmylease.astonmartinsummitstagetest.test;

import com.runmylease.astonmartinsummitstage.driver.DriverSingleton;
import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void browserSetUp() {
        CustomLogger.info("BaseTest.browserSetUp()");
        DriverSingleton.getDriver();
    }
    @AfterClass(alwaysRun = true)
    public void browserTearDown() throws InterruptedException {
        Thread.sleep(3000); //todo remove
        DriverSingleton.closeBrowser();
    }
}

