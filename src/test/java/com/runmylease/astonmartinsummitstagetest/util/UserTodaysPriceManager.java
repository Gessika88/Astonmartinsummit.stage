package com.runmylease.astonmartinsummitstagetest.util;

import com.runmylease.astonmartinsummitstagetest.user.TodaysPrice;

public class UserTodaysPriceManager {

    private static final String USER_FILE_PATH = "src/test/resources/testData/userDataTodaysPrice.json";
    private static TodaysPrice user;

    public static TodaysPrice getUser(){
        if (user == null){
            user = UserTodaysPriceParser.parseUserDataFromFileToUserObject(new TodaysPrice(), USER_FILE_PATH);
        }
        return user;
    }

}
