package com.runmylease.astonmartinsummitstage.base;

import com.runmylease.astonmartinsummitstage.driver.DriverSingleton;
import com.runmylease.astonmartinsummitstage.util.ConditionalWait;
import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement {

    private By locator;
    private String elementName;

    public BaseElement(By locator, String elementName){
        this.locator = locator;
        this.elementName = elementName;
    }

    protected BaseElement() {
    }

    public By getLocator() {
        return locator;
    }

    public String getElementName() {
        return elementName;
    }

    protected WebElement findElement(By locator) {
        CustomLogger.info(this.getElementName() + " :findElement(By locator)");
        return DriverSingleton.getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        CustomLogger.info(this.getElementName() + " :findElement(By locator)");
        return DriverSingleton.getDriver().findElements(locator);
    }

    public boolean isDisplayed() {
        CustomLogger.info(this.getElementName() + " :isDisplayed()");
        return !DriverSingleton.getDriver().findElements(locator).isEmpty();
    }

    public boolean isPreOwnedVehiclePageDisplayed() {
        CustomLogger.info(this.getElementName() + " :isDisplayed()");
        return !DriverSingleton.getDriver().findElements(locator).isEmpty();
    }


    public void click() {
//        JSUtil.pageScrollDown(locator);
        ConditionalWait.waitToBeClickableByLocator(locator);
        CustomLogger.info(this.getElementName() + " :click()");
        findElement(locator).click();
    }

    public void clickForOpenVDP() {
//        JSUtil.pageScrollDown(locator);
        ConditionalWait.waitToBeClickableByLocator(locator);
        CustomLogger.info(this.getElementName() + " :click()");
        findElement(locator).click();
    }



    public void moveToElement(){
        new Actions(DriverSingleton.getDriver()).moveToElement(findElement(locator)).perform();
    }

    public String getText() {
        CustomLogger.info(this.getElementName() + " :getText()");
        return findElement(locator).getText();
    }


}
