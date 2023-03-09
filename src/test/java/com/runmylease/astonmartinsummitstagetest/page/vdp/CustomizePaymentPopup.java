package com.runmylease.astonmartinsummitstagetest.page.vdp;

import com.runmylease.astonmartinsummitstage.base.BaseForm;
import com.runmylease.astonmartinsummitstage.element.Button;
import com.runmylease.astonmartinsummitstage.element.Label;
import com.runmylease.astonmartinsummitstage.element.TextBox;
import com.runmylease.astonmartinsummitstagetest.user.CustomizeYourPayment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CustomizePaymentPopup extends BaseForm {

    private static Label preOwnedVehicleLbL
            = new Label(By.xpath("//h2[contains(@class,'section-header_title__ULLsx')]"), "preOwnedVehicleLbL");

    private static Label preOwnedVehiclePageLbL
            = new Label(By.xpath("//*[@id='newVehiclesCatalog']/div/div[1]/h2"), "preOwnedVehiclePageLbL");

    private static Label priceDetailsLbL
            = new Label(By.xpath("//h3[contains(@class,'price-details_title__aWkWW')]"), "priceDetailsLbL");

    // Customize Payment popup
    private static Label customizePaymentElemLbL
            = new Label(By.xpath("//label[contains(@class,'styles_label__6RFdJ')]"), "customizePaymentElemLbL");

    private static Label personalUnlockCodeSentWindowLbL
            = new Label(By.xpath("//h4[contains(@class,'personal-code_title__Caf1I')]"), "personalUnlockCodeSentWindowLbL");

    private static Label personalUnlockCodeSentWindowFieldCodeLbL
            = new Label(By.xpath("//label[contains(@class,'styles_label__bJz3l')]"), "personalUnlockCodeSentWindowFieldCodeLbL" +
            "");

    private static Label customizeYourPaymentWindowOpenedLbL
            = new Label(By.xpath("//*[@id='__next']/section/div/section[2]/h4"), "customizeYourPaymentWindowOpenedLbL");

    private static Label customizeYourPaymentElemLbL
            = new Label(By.xpath("//label[contains(@class,'styles_label__bJz3l')]"), "customizeYourPaymentElemLbL");

    private static Label customizeYourPaymentElem2LbL
            = new Label(By.xpath("//p[contains(@class,'customize-finance_subtitle__8ucpM')]"), "customizeYourPaymentElem2LbL");

    private static Label acknowledgmentTextPageLbL
            = new Label(By.xpath("//h4[contains(@class,'thank-you_title__WSFOe')]"), "acknowledgmentTextPageLbL");



    private static Button VDPFirstCarBtn
            = new Button(By.xpath("//div[@class='car-card-grid_descriptionContainer__HOPoN'][1]"), "VDPFirstCarBtn");

    private static Button customizePaymentWindowBtn
            = new Button(By.xpath("//span[contains(@class, 'finance_button_text finance_button_customize_text')]"), "customizePaymentWindowBtn");

    private static Button preferredContactDropDownBtn =
            new Button (By.xpath("//div[contains(@class,'styles_option__7uaM_ styles_optionSelected__iBI4C')]"), "preferredContactDropDownBtn");

    private static Button emailBtn =
            new Button(By.xpath("//li[contains(@class,'styles_option__7uaM_')][3]"), "emailBtn");

    private static Button nextBtn =
            new Button(By.xpath("//*[@id='__next']/section/div/div/button"), "nextBtn");

    private static Button calculatePaymentBtn =
            new Button(By.xpath("//button[contains(@class,'styles_button__2CcKk personal-code_button__NdwLV styles_primary__LOVSi')]"), "calculatePaymentBtn");

    private static Button lockInThisPaymentBtn =
            new Button(By.xpath("//button[contains(@class,'styles_button__2CcKk customize-finance_submitButton__dwGFY styles_primary__LOVSi')]"), "lockInThisPaymentBtn");

    private static Button doneBtn =
            new Button(By.xpath("//button[contains(@class,'styles_button__2CcKk thank-you_done__gjNRn styles_primary__LOVSi')]"), "doneBtn");




    private TextBox customizePaymentFirstNameTextBox = new TextBox(By.xpath("//input[@id = 'firstName']"), "First name input field");
    private TextBox customizePaymentLastNameTextBox = new TextBox(By.xpath("//input[@id = 'lastName']"), "Last name input field");
    private TextBox customizePaymentEmailAddressTextBox = new TextBox(By.xpath("//input[@id = 'email']"), "Email Address input field");
    private TextBox customizePaymentZipCodeTextBox = new TextBox(By.xpath("//input[@id = 'zipCode']"), "Zip Code Address input field");
    private TextBox fieldCodeTextBox = new TextBox(By.xpath("//*[@id='__next']/section/div/section[2]/div/div/input"), "Code verification field");




    public CustomizePaymentPopup(){
        super(preOwnedVehicleLbL, "preOwnedVehicleLbL");
    }

    public boolean isPreOwnedVehiclePageOpened(){
        return preOwnedVehiclePageLbL.isPreOwnedVehiclePageDisplayed();
    }

    public CustomizePaymentPopup openVDPFirstCar() {
        VDPFirstCarBtn.clickForOpenVDP();
        return this;
    }

    public boolean isVDPFistCarOpened() {
        return priceDetailsLbL.isDisplayed();
    }


    //customize payment
    public CustomizePaymentPopup openCustomizePayment() {
        customizePaymentWindowBtn.click();
        return this;
    }

    public List getFieldsNameList() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> fieldsNameWebElementList = customizePaymentElemLbL.findElements(); //получаю список вэб-элементов
        List<String> fieldsNameList = new ArrayList<>(); //создание массива для добавления туда этих элементов
        for (WebElement element : fieldsNameWebElementList){
            fieldsNameList.add(element.getText());
        }
        return fieldsNameList;
    }

    public void inputFirstName(CustomizeYourPayment user) {
        customizePaymentFirstNameTextBox.sendText(user.getFirstName());
    }
    public void inputLastName(CustomizeYourPayment user) {
        customizePaymentLastNameTextBox.sendText(user.getLastName());
    }
    public void inputEmailAddress(CustomizeYourPayment user) {
        customizePaymentEmailAddressTextBox.sendText(user.getEmailAddress());
    }
    public void inputZipCode(CustomizeYourPayment user) {
        customizePaymentZipCodeTextBox.sendText(user.getZipCode());
    }

    public CustomizePaymentPopup openPreferredContactDropDown() {
        preferredContactDropDownBtn.click();
        return this;
    }

    public void chooseCustomizePaymentEmail() {
        emailBtn.click();
    }

    public CustomizePaymentPopup openPersonalUnlockCodeSentWindow() throws InterruptedException {
//        Thread.sleep(2000);
        nextBtn.click();
        return this;
    }

    public String personalUnlockCodeSentWindowCheckField() {
        return personalUnlockCodeSentWindowFieldCodeLbL.getText();
    }

    public boolean isPersonalUnlockCodeSentWindowOpened() throws InterruptedException {
        Thread.sleep(2000);
        return personalUnlockCodeSentWindowLbL.isDisplayed();
    }

    public void inputCodeVerification(String codeVerification) {
        fieldCodeTextBox.sendText(codeVerification);
    }

    public CustomizePaymentPopup openCustomizeYourPayment()  {
        calculatePaymentBtn.click();
        return this;
    }

    public boolean isСustomizeYourPaymentPageOpened() throws InterruptedException {
        Thread.sleep(2000);
        return customizeYourPaymentWindowOpenedLbL.isDisplayed();
    }

    public List getFieldsInfoList() {

        List<WebElement> fieldsInfoWebElementList = customizeYourPaymentElemLbL.findElements(); //получаю список вэб-элементов
        List<String> fieldsInfoList = new ArrayList<>(); //создание массива для списка названий полей
        for (WebElement element : fieldsInfoWebElementList){
            fieldsInfoList.add(element.getText());
        }

        List<WebElement> fieldsInfoWebElementList2 = customizeYourPaymentElem2LbL.findElements();
        for (WebElement element : fieldsInfoWebElementList2){
            fieldsInfoList.add(element.getText());
        }
        return fieldsInfoList;

    }

    public CustomizePaymentPopup openAcknowledgmentTextPage()  {
        lockInThisPaymentBtn.click();
        return this;
    }

    public boolean isAcknowledgmentTextPageOpened() throws InterruptedException {
        Thread.sleep(2000);
        return acknowledgmentTextPageLbL.isDisplayed();
    }

    public CustomizePaymentPopup closingAcknowledgmentTextPage()  {
        doneBtn.click();
        return this;
    }

}
