package com.runmylease.astonmartinsummitstagetest.test.vdp.todaysPrice;

import com.runmylease.astonmartinsummitstage.util.BrowserUtil;
import com.runmylease.astonmartinsummitstage.util.ConfigManager;
import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstage.util.FrameUtil;
import com.runmylease.astonmartinsummitstagetest.manager.TodaysPriceManager;
import com.runmylease.astonmartinsummitstagetest.user.TodaysPrice;
import com.runmylease.astonmartinsummitstagetest.page.HomePage;
import com.runmylease.astonmartinsummitstagetest.page.vdp.TodaysPricePopup;
import com.runmylease.astonmartinsummitstagetest.test.BaseTest;
import com.runmylease.astonmartinsummitstagetest.util.UserTodaysPriceManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TodaysPriceAllRequiredFieldsTest extends BaseTest {
    @Test
    public void testTodaysPrice() throws InterruptedException {
        CustomLogger.info("Today's price test starts.");
        HomePage homePage = new HomePage();
        BrowserUtil.goToURL(ConfigManager.getURL());
        CustomLogger.info("Step 1. Assert if the main page is opened.");

        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened.");

        CustomLogger.info("Step 2. Assert if the  PRE-OWNED VEHICLES page is opened.");
        homePage
                .moveToPreOwnedVehiclesBtn()
                .openAllPreOwnedVehiclesPage();
        TodaysPricePopup todaysPricePopup = new TodaysPricePopup();

        Assert.assertTrue(todaysPricePopup.isPreOwnedVehiclePageOpen(), "PRE-OWNED VEHICLES page isn't opened");

        CustomLogger.info("Step 3. Assert if VDP is opened.");
        todaysPricePopup.openVDPFirstCar();

        Assert.assertTrue(todaysPricePopup.isVDPFistCarOpen(), "VDP isn't opened");

        CustomLogger.info("Step 4. Assert if popup with fields is opened.");
        todaysPricePopup.openTodaysPrice();
        FrameUtil.switchToFrame(By.xpath("//iframe[@name = 'iframe']"));

        List actualFieldsNames = todaysPricePopup.getFieldsNamesList();
        List expectedFieldsNames = TodaysPriceManager.getTodaysPriceExpectedList();

        for (int i = 0; i < actualFieldsNames.size() ; i++) {
            Assert.assertTrue(expectedFieldsNames.contains(actualFieldsNames.get(i)),
                    "Popup must not contain the expected result: " + actualFieldsNames.get(i));
        }

        CustomLogger.info("Step 5. Assert if popup is filled and window with acknowledgment text is opened.");
        TodaysPrice user = UserTodaysPriceManager.getUser();

        todaysPricePopup.inputFirstName(user);
        todaysPricePopup.inputLastName(user);
        todaysPricePopup.inputEmailAddress(user);
        todaysPricePopup.openPreferredContactDropDown();
        todaysPricePopup.chooseTodaysPriceEmail();
        todaysPricePopup.openWindowWithAcknowledgmentText();

        Assert.assertTrue(todaysPricePopup.isWindowWithAcknowledgmentTextOpened(), "Window with acknowledgment Text is not opened.");


        CustomLogger.info("Step 6. Assert if popup is closed.");

        todaysPricePopup.closeTodaysPricePopUp();



    }
}
