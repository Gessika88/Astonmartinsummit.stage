package com.runmylease.astonmartinsummitstage.driver;

import com.runmylease.astonmartinsummitstage.util.ConfigManager;
import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){
    }

    public static WebDriver getDriver() {
        if(driver == null){
            String browserName = ConfigManager.getBrowserName();
            String options = ConfigManager.getOptions();
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments(options);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments(options);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new RuntimeException("Browser unknown or/is not defined");
            }
        }
        return driver;
    }

    public static void closeBrowser() {
        CustomLogger.info("BrowserUtil.closeBrowser()");
        DriverSingleton.getDriver().quit();
        driver = null;
    }
}
