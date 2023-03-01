package com.runmylease.astonmartinsummitstagetest.util;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.model.User;

public class UserManager2 {

    private static final String USER_FILE_PATH = "src/test/resources/testData/userData.json";
    private static User user;

    public static User getUser(){
        if (user == null){
            user = UserParser.parseUserDataFromFileToUserObject(new User(), USER_FILE_PATH);
        }
        return user;
    }

    public static String getPrice(){
        CustomLogger.info("UserManager2.getPrice()");
        return getUser().getPrice();
    }

    public static String getTerm(){
        CustomLogger.info("UserManager2.getTerm()");
        return getUser().getTerm();
    }

    public static String getCreditScore(){
        CustomLogger.info("UserManager2.getCreditScore");
        return getUser().getCreditScore();
    }

    public static String getInterestRate(){
        CustomLogger.info("UserManager.getInterestRate");
        return getUser().getInterestRate();
    }

    public static String getDownPayment(){
        CustomLogger.info("UserManager.getDownPayment");
        return getUser().getDownPayment();
    }


}
