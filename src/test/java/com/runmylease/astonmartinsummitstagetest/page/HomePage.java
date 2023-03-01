package com.runmylease.astonmartinsummitstagetest.page;

import com.runmylease.astonmartinsummitstage.base.BaseForm;
import com.runmylease.astonmartinsummitstage.element.Button;
import com.runmylease.astonmartinsummitstage.element.Label;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    // todo improve locator,remove index
    private static Label astonMartinLogo
            = new Label(By.xpath("//a[contains(@class,'header-additional_logo__Hocwa')]"), "astonMartinLogo");
    private static Button workingHoursBtn
            = new Button(By.xpath("//*[@id='headerAdditional']/div[1]/div"), "workingHoursBtn");
    private static Label weekdayLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/div/span[1]"), "weekdayLbl");

    private static Label monLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/ul/div[1]"), "monLbl");

    private static Label tueLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/ul/div[2]"), "tueLbl");
    private static Label wedLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/ul/div[3]"), "wedLbl");
    private static Label thuLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/ul/div[4]"), "thuLbl");
    private static Label friLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/ul/div[5]"), "friLbl");
    private static Label satLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/ul/div[6]"), "satLbl");
    private static Label sunLbl
            = new Label(By.xpath("//*[@id='headerAdditional']/div[1]/ul/div[7]"), "sunLbl");

    private static Button preOwnedVehiclesBtn
            = new Button (By.xpath("//*[@id='__next']/header/div[2]/div/nav/div[2]/a/span"), "preOwnedVehiclesBtn");

    private static Button allPreOwnedVehiclesBtn
            = new Button (By.xpath("//div[contains(@class,'header-desktop_submenuContainer__c3ulv')]"), "preOwnedVehiclesBtn");




    public HomePage() {
        super(astonMartinLogo, "astonMartinLogo");
    }

    public boolean isWorkingHoursDisplayed() {
        return workingHoursBtn.isDisplayed();
    }

    public String getTextWeekdayLbl() {
        return weekdayLbl.getText();
    }

    public HomePage clickWorkingHoursBtn() {
        workingHoursBtn.click();
        return this;
    }

    public boolean isMonDisplayed() {
        return monLbl.isDisplayed();
    }

    public boolean isTueDisplayed() {
        return tueLbl.isDisplayed();
    }

    public boolean isWedDisplayed() {
        return wedLbl.isDisplayed();
    }

    public boolean isThuDisplayed() {
        return thuLbl.isDisplayed();
    }

    public boolean isFriDisplayed() {
        return friLbl.isDisplayed();
    }

    public boolean isSatDisplayed() {
        return satLbl.isDisplayed();
    }

    public boolean isSunDisplayed() {
        return sunLbl.isDisplayed();
    }

    //    public void openPreOwnedVehiclesPage(){
//        preOwnedVehiclesBtn.click();
//    }
    public HomePage moveToPreOwnedVehiclesBtn() {
        preOwnedVehiclesBtn.moveToElement();
        return this;
    }

    public HomePage openAllPreOwnedVehiclesPage() {
        allPreOwnedVehiclesBtn.click();
        return this;
    }




}
