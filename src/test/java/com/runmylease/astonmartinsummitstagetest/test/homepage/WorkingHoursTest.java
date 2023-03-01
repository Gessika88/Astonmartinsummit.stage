package com.runmylease.astonmartinsummitstagetest.test.homepage;

import com.runmylease.astonmartinsummitstage.util.BrowserUtil;
import com.runmylease.astonmartinsummitstage.util.ConfigManager;
import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.page.HomePage;
import com.runmylease.astonmartinsummitstagetest.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkingHoursTest extends BaseTest {

    @Test
    public void testWorkingHours() {
        CustomLogger.info("Working hours test starts.");
        HomePage homePage = new HomePage();
        BrowserUtil.goToURL(ConfigManager.getURL());
        CustomLogger.info("Step 1.1. Assert if the main page is opened.");

        Assert.assertTrue(homePage.isPageOpened(), "Main page isn't opened.");

        CustomLogger.info("Step 1.2. Assert if the working hours are displayed.");

        Assert.assertTrue(homePage.isWorkingHoursDisplayed(), "Working hours isn't displayed.");

        CustomLogger.info("Step 1.3. Assert if the correct day of the week is displayed.");
        String weekDayFromSite = (homePage.getTextWeekdayLbl()).toLowerCase();
        String currentWeekDay = (String.valueOf(DayOfWeek.from(LocalDate.now()))).toLowerCase();

        Assert.assertTrue(currentWeekDay.contains(weekDayFromSite), "The working day is displayed incorrectly.");

        CustomLogger.info("Step 2. Assert if all days of the week are displayed.");
        homePage.clickWorkingHoursBtn();

        Assert.assertTrue(homePage.isMonDisplayed(), "Monday does not appear in the schedule");

        Assert.assertTrue(homePage.isTueDisplayed(), "Tuesday does not appear in the schedule");

        Assert.assertTrue(homePage.isWedDisplayed(), "Wednesday does not appear in the schedule");

        Assert.assertTrue(homePage.isThuDisplayed(), "Thursday does not appear in the schedule");

        Assert.assertTrue(homePage.isFriDisplayed(), "Friday does not appear in the schedule");

        Assert.assertTrue(homePage.isSatDisplayed(), "Saturday does not appear in the schedule");

        Assert.assertTrue(homePage.isSunDisplayed(), "Sunday does not appear in the schedule");

    }
}

