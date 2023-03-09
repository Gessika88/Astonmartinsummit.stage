package com.runmylease.astonmartinsummitstagetest.page.vdp;

import com.runmylease.astonmartinsummitstage.base.BaseForm;
import com.runmylease.astonmartinsummitstage.element.Button;
import com.runmylease.astonmartinsummitstage.element.Label;
import com.runmylease.astonmartinsummitstage.element.TextBox;
import com.runmylease.astonmartinsummitstagetest.user.TodaysPrice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TodaysPricePopup extends BaseForm {

    private static Label preOwnedVehicleLbL
            = new Label(By.xpath("//h2[contains(@class,'section-header_title__ULLsx')]"), "preOwnedVehicleLbL");

    private static Label preOwnedVehiclePageLbL
            = new Label(By.xpath("//*[@id='newVehiclesCatalog']/div/div[1]/h2"), "preOwnedVehiclePageLbL");

    private static Label priceDetailsLbL
            = new Label(By.xpath("//h3[contains(@class,'price-details_title__aWkWW')]"), "priceDetailsLbL");

    private static Label todaysPriceElemLbL
            = new Label(By.xpath("//label[contains(@class,'styles_label__6RFdJ')]"), "todaysPriceElemLbL");

    private static Label windowWithAcknowledgmentTextLbL
            = new Label(By.xpath("//*[@id='__next']/section/section[2]/h4"), "windowWithAcknowledgmentTextLbL");




    private static Button vdpFirstCarBtn
            = new Button(By.xpath("//div[@class='car-card-grid_descriptionContainer__HOPoN'][1]"), "vdpFirstCarBtn");

    private static Button todaysPriceBtn
            = new Button(By.xpath("//button[contains(@class, 'get_todays_price_button_qwe')]"), "todaysPriceBtn");

    private static Button preferredContactDropDownBtn =
            new Button (By.xpath("//div[contains(@class,'styles_option__7uaM_ styles_optionSelected__iBI4C')]"), "preferredContactDropDownBtn");

    private static Button emailBtn =
            new Button(By.xpath("//li[contains(@class,'styles_option__7uaM_')][3]"), "emailBtn");
    private static Button getTodaysPriceBtn =
            new Button(By.xpath("//*[@id='__next']/section/div/button"), "getTodaysPriceBtn");
    private static Button doneBtN =
            new Button(By.xpath("//*[@id='__next']/section/section[2]/button"), "doneBtN");





    private TextBox todaysPriceFirstNameTextBox = new TextBox(By.xpath("//input[@id = 'firstName']"), "First name input field");
    private TextBox todaysPriceLastNameTextBox = new TextBox(By.xpath("//input[@id = 'lastName']"), "Last name input field");
    private TextBox todaysPriceEmailAddressTextBox = new TextBox(By.xpath("//input[@id = 'email']"), "Email Address input field");









    public TodaysPricePopup(){
        super(preOwnedVehicleLbL, "preOwnedVehicleLbL");
    }

    public boolean isPreOwnedVehiclePageOpen(){
        return preOwnedVehiclePageLbL.isPreOwnedVehiclePageDisplayed();
    }

    public TodaysPricePopup openVDPFirstCar() {
        vdpFirstCarBtn.clickForOpenVDP();
        return this;
    }

    public boolean isVDPFistCarOpen() {
        return priceDetailsLbL.isDisplayed();
    }



    public TodaysPricePopup openTodaysPrice() {
        todaysPriceBtn.click();
        return this;
    }

    public List getFieldsNamesList() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> fieldsNamesWebElementList = todaysPriceElemLbL.findElements(); //получаю список вэб-элементов
        List<String> fieldsNamesList = new ArrayList<>(); //создание массива для добавления туда этих элементов
        for (WebElement element : fieldsNamesWebElementList){
            fieldsNamesList.add(element.getText());
        }
        return fieldsNamesList;
    }

    public void inputFirstName(TodaysPrice user) {
        todaysPriceFirstNameTextBox.sendText(user.getFirstName());
    }
    public void inputLastName(TodaysPrice user) {
        todaysPriceLastNameTextBox.sendText(user.getLastName());
    }
    public void inputEmailAddress(TodaysPrice user) {
        todaysPriceEmailAddressTextBox.sendText(user.getEmailAddress());
    }

    public TodaysPricePopup openPreferredContactDropDown() {
        preferredContactDropDownBtn.click();
        return this;
    }

    public void chooseTodaysPriceEmail() {
        emailBtn.click();
    }

    public TodaysPricePopup openWindowWithAcknowledgmentText() {
        getTodaysPriceBtn.click();
        return this;
    }

    public boolean isWindowWithAcknowledgmentTextOpened() throws InterruptedException {
        Thread.sleep(2000);
        return windowWithAcknowledgmentTextLbL.isDisplayed();
    }

    public void closeTodaysPricePopUp() {
        doneBtN.click();
    }

}

