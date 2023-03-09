package com.runmylease.astonmartinsummitstagetest.manager;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.user.TodaysPrice;
import com.runmylease.astonmartinsummitstagetest.parser.TodaysPriceParser;

import java.util.ArrayList;
import java.util.List;

public class TodaysPriceManager {

    private static final String TODAYS_PRICE_FILE_PATH = "src/test/resources/testData/todaysPricePopUp.json";
    private static TodaysPrice todaysPrice;

    public static TodaysPrice getTodaysPrice(){
        if (todaysPrice == null){
            todaysPrice = TodaysPriceParser.parseTodaysPriceDataFromFileToUserObject(new TodaysPrice(), TODAYS_PRICE_FILE_PATH);
        }
        return todaysPrice;
    }

    public static String getFirstName(){
        CustomLogger.info("TodaysPriceManager.getFirstName()");
        return getTodaysPrice().getFirstName();
    }

    public static String getLastName(){
        CustomLogger.info("TodaysPriceManager.getSecondName()");
        return getTodaysPrice().getLastName();
    }

    public static String getPreferredContact(){
        CustomLogger.info("TodaysPriceManager.getPreferredContact()");
        return getTodaysPrice().getPreferredContact();
    }

    public static String getPhone(){
        CustomLogger.info("TodaysPriceManager.getPhone()");
        return getTodaysPrice().getPhone();
    }

    public static String getEmail(){
        CustomLogger.info("TodaysPriceManager.getEmail()");
        return getTodaysPrice().getEmailAddress();
    }

    public static String getComments(){
        CustomLogger.info("TodaysPriceManager.getComments()");
        return getTodaysPrice().getComments();
    }

    public static List <String> getTodaysPriceExpectedList(){
        List todaysPriceExpectedList = new ArrayList<>();
        todaysPriceExpectedList.add(getFirstName());
        todaysPriceExpectedList.add(getLastName());
        todaysPriceExpectedList.add(getPreferredContact());
        todaysPriceExpectedList.add(getPhone());
        todaysPriceExpectedList.add(getEmail());
        todaysPriceExpectedList.add(getComments());
        return todaysPriceExpectedList;
    }


}

