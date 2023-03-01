package com.runmylease.astonmartinsummitstagetest.test.vdp.todaysPrice;

import com.runmylease.astonmartinsummitstage.util.BrowserUtil;
import com.runmylease.astonmartinsummitstage.util.ConfigManager;
import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.page.HomePage;
import com.runmylease.astonmartinsummitstagetest.page.vdp.CustomizePaymentPopup;
import com.runmylease.astonmartinsummitstagetest.page.vdp.TodaysPricePopup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodaysPriceAllRequiredFieldsTest {
    @Test
    public void testCustomizePayment() {
        CustomLogger.info("Customize Payment test starts.");
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





    }
}
