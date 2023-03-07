package com.runmylease.astonmartinsummitstagetest.test.vdp.customizePayment;

import com.runmylease.astonmartinsummitstage.util.*;
import com.runmylease.astonmartinsummitstagetest.manager.CustomizeYourPaymentManager2;
import com.runmylease.astonmartinsummitstagetest.model.User;
import com.runmylease.astonmartinsummitstagetest.page.HomePage;
import com.runmylease.astonmartinsummitstagetest.page.vdp.CustomizePaymentPopup;
import com.runmylease.astonmartinsummitstagetest.page.vdp.GoogleAuthorization;
import com.runmylease.astonmartinsummitstagetest.test.BaseTest;
import com.runmylease.astonmartinsummitstagetest.manager.CustomizeYourPaymentManager;
import com.runmylease.astonmartinsummitstagetest.util.UserManager;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CustomizePaymentAllRequiredFieldsTest extends BaseTest {

    @Test
    public void testCustomizePayment() throws InterruptedException {
        CustomLogger.info("Customize Payment test starts.");
        HomePage homePage = new HomePage();
        BrowserUtil.goToURL(ConfigManager.getURL());
        CustomLogger.info("Step 1. Assert if the main page is opened.");

        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");

        CustomLogger.info("Step 2. Assert if the  PRE-OWNED VEHICLES page is opened.");
        homePage
                .moveToPreOwnedVehiclesBtn()
                .openAllPreOwnedVehiclesPage();
        CustomizePaymentPopup customizePaymentPopup = new CustomizePaymentPopup();

        Assert.assertTrue(customizePaymentPopup.isPreOwnedVehiclePageOpened(), "PRE-OWNED VEHICLES page isn't opened");

        CustomLogger.info("Step 3. Assert if VDP is opened.");
        customizePaymentPopup.openVDPFirstCar();

        Assert.assertTrue(customizePaymentPopup.isVDPFistCarOpened(), "VDP isn't opened");

        CustomLogger.info("Step 4. Assert if popup with fields is opened.");
        customizePaymentPopup.openCustomizePayment();
        FrameUtil.switchToFrame(By.xpath("//iframe[@name = 'iframe']"));


        List actualContactInfo = customizePaymentPopup.getContactInfoList();
        List expectedContactInfo = CustomizeYourPaymentManager.getCustomizeYourPaymentExpectedList();

        for (int i = 0; i < actualContactInfo.size() ; i++) {
            Assert.assertTrue(expectedContactInfo.contains(actualContactInfo.get(i)),
                    "Popup must not contain the expected result: " + actualContactInfo.get(i));
        }

        CustomLogger.info("Step 5. Assert if popup is filled and window with field Code is opened.");
        User user = UserManager.getUser();

        customizePaymentPopup.inputFirstName(user);
        customizePaymentPopup.inputLastName(user);
        customizePaymentPopup.inputEmailAddress(user);
        customizePaymentPopup.inputZipCode(user);
        customizePaymentPopup.openPreferredContactDropDown();
        customizePaymentPopup.chooseCustomizePaymentEmail();
        customizePaymentPopup.openPersonalUnlockCodeSentWindow();
        String fieldCode = customizePaymentPopup.personalUnlockCodeSentWindowCheckField();

        Assert.assertTrue(customizePaymentPopup.isPersonalUnlockCodeSentWindowOpened(), "Unlock Code Window isn't opened.");
        Assert.assertEquals(fieldCode, "Code *");

        CustomLogger.info("Step 6. Assert if google page with field Email or phone is opened");
        GoogleAuthorization googleAuthorization = new GoogleAuthorization();
        googleAuthorization.openNewTab();
        FrameUtil.switchToWindow(By.xpath("//div[contains(@class,'iNstf')]"));

        Assert.assertTrue(googleAuthorization.isGoogleAuthorizationPageOpened(), "Google page with field Email or phone is not opened");


        CustomLogger.info("Step 7. Assert if field Email or phone is filled and page with field Enter your password is opened");
        googleAuthorization.inputEmail("mkosach@runmylease.com");
        googleAuthorization.openGooglePasswordPage();

        Assert.assertTrue(googleAuthorization.isGoogleAuthorizationPasswordPageOpened(), "Google page with field Password is not opened");


        CustomLogger.info("Step 8. Assert if field Password is filled and page with emails is opened");
        googleAuthorization.inputPassword("Kristian03102018");
        googleAuthorization.openGoogleEmailPage();
        googleAuthorization.clickButtonPauseMobileNotifications();

        Assert.assertTrue(googleAuthorization.isGoogleEmailsPageOpened(), "Page with emails is not opened");


        CustomLogger.info("Step 9. Assert if code verification is copied.");
        googleAuthorization.inputToFieldSearchInMail("no-reply@runmylease.com");
        googleAuthorization.searchMails();
        String codeVerification = googleAuthorization.getTextFromList();
        googleAuthorization.selectUnreadMail();
        googleAuthorization.pushMarkAsReadMails();

        Assert.assertTrue(NumberUtils.isParsable(codeVerification), "It's not a code verification");


        CustomLogger.info("Step 10. Assert if Unlock Code Window is opened.");
        FrameUtil.switchToWindow(By.xpath("/html/body/div[5]/div"));
        FrameUtil.switchToFrame(By.xpath("//iframe[@name = 'iframe']"));

        Assert.assertTrue(customizePaymentPopup.isPersonalUnlockCodeSentWindowOpened(), "Unlock Code Window isn't opened.");


        CustomLogger.info("Step 11. Assert if popup Customize your payment with fields is opened.");
        customizePaymentPopup.inputCodeVerification(codeVerification);
        customizePaymentPopup.openCustomizeYourPayment();

        Assert.assertTrue(customizePaymentPopup.isСustomizeYourPaymentPageOpened(), "Customize your payment is not opened.");


        List actualFieldsInfo = customizePaymentPopup.getFieldsInfoList();
        List expectedFieldsInfo = CustomizeYourPaymentManager2.getCustomizeYourPaymentExpected2List();

        for (int i = 0; i < actualFieldsInfo.size() ; i++) {

            Assert.assertTrue(expectedFieldsInfo.contains(actualFieldsInfo.get(i)),
                    "Popup must not contain the expected result: " + actualFieldsInfo.get(i));
        }


        CustomLogger.info("Step 12. Assert if popup with acknowledgment text is opened.");
        customizePaymentPopup.openAcknowledgmentTextPage();

        Assert.assertTrue(customizePaymentPopup.isAcknowledgmentTextPageOpened());


        CustomLogger.info("Step 13. Assert if popup is closed.");
        customizePaymentPopup.closingAcknowledgmentTextPage();













    }
}
