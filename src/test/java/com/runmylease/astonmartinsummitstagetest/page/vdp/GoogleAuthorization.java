package com.runmylease.astonmartinsummitstagetest.page.vdp;

import com.runmylease.astonmartinsummitstage.base.BaseForm;
import com.runmylease.astonmartinsummitstage.driver.DriverSingleton;
import com.runmylease.astonmartinsummitstage.element.Button;
import com.runmylease.astonmartinsummitstage.element.Label;
import com.runmylease.astonmartinsummitstage.element.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleAuthorization extends BaseForm {
    private static Label googleAuthorizationEmailPageLbL
            = new Label(By.xpath("//*[@id='identifierId']"), "googleAuthorizationEmailPageLbL");

    private static Label googleAuthorizationPasswordPageLbL
            = new Label(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"), "googleAuthorizationPasswordPageLbL");

    private static Label googleEmailsPageLbL
            = new Label(By.xpath("//*[@id=':kj']/div/div[2]/span/a"), "googleEmailsPageLbL");

//    private static Label googleEmailsElemLbL
//            = new Label(By.xpath("//span[contains(text(),'Verification code:')]"), "googleEmailsElemLbL");




    private static Button emailNextBtn =
            new Button(By.xpath("//button[contains(@class,'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ')]"), "emailNextBtn");

    private static Button passwordNextBtn =
            new Button(By.xpath("//*[@id='passwordNext']/div/button/span"), "passwordNextBtn");

    private static Button pauseMobileNotificationsBtN =
            new Button(By.xpath("//button[@jslog='122573; u014N:cOuCgd,xr6bB']"), "pauseMobileNotificationsBtN");

    private static Button fieldSearchBtN =
            new Button(By.xpath("//form[@id='aso_search_form_anchor']/button[4]"), "fieldSearchBtN");

    private static Button selectCheckBoxUnreadMailBtN =
            new Button(By.xpath("//*[@id=':m3']/div[1]/span"), "selectCheckBoxUnreadMailBtN");

    private static Button pushMarkAsReadBtN =
            new Button(By.xpath("//*[@id=':4']/div[2]/div[2]/div[1]/div/div/div[3]/div[1]/div"), "pushMarkAsReadBtN");





    private TextBox googleAuthorizationEmailTextBox = new TextBox(By.id("identifierId"), "Email input field");

    private TextBox googleAuthorizationPasswordTextBox = new TextBox(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"), "Password input field");

    private TextBox fieldSearchInMailTextBox = new TextBox(By.xpath("//*[@id='gs_lc50']/input[1]"), "Search input field");








    public void openNewTab() {
        ((JavascriptExecutor) DriverSingleton.getDriver()).executeScript("window.open('https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=1209600&osid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&emr=1&ifkv=AWnogHdwx7nqLRt4AB-V9ckjMDjFW7WNcfGJDGTCjHKaldKJWfW7jY_-252VgXT1HmnIi6rIBkhqhA&flowName=GlifWebSignIn&flowEntry=ServiceLogin')");

    }

    public boolean isGoogleAuthorizationPageOpened() {
        return googleAuthorizationEmailPageLbL.isDisplayed();
    }

    public void inputEmail(String mail) {
        googleAuthorizationEmailTextBox.sendText(mail);
    }

    public GoogleAuthorization openGooglePasswordPage() {
        emailNextBtn.click();
        return this;
    }

    public boolean isGoogleAuthorizationPasswordPageOpened() throws InterruptedException {
        Thread.sleep(2000);
        return googleAuthorizationPasswordPageLbL.isDisplayed();
    }

    public void inputPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        googleAuthorizationPasswordTextBox.sendText(password);
    }

    public GoogleAuthorization openGoogleEmailPage() {
        passwordNextBtn.click();
        return this;
    }

    public void clickButtonPauseMobileNotifications(){
        pauseMobileNotificationsBtN.click();
    }

    public boolean isGoogleEmailsPageOpened() throws InterruptedException {
        Thread.sleep(2000);
        return googleEmailsPageLbL.isDisplayed();
    }

    public void inputToFieldSearchInMail(String email) throws InterruptedException {
        Thread.sleep(1000);
        fieldSearchInMailTextBox.sendText(email);
    }

    public void searchMails(){
        fieldSearchBtN.click();
    }

    public String getTextFromList()  {
        String result = "";
        List <WebElement> elements = DriverSingleton.getDriver().findElements(By.xpath("//span[contains(text(),'Verification code:')]"));
        for(int i = 0; i < elements.size(); i++){
            result = elements.get(0).getText().replaceAll("\\D+", "");
        }
       return result;
    }

    public void selectUnreadMail() throws InterruptedException {
        Thread.sleep(2000);
        selectCheckBoxUnreadMailBtN.click();
    }

    public void pushMarkAsReadMails() {
        pushMarkAsReadBtN.click();
    }

}

