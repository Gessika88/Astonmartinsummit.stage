package com.runmylease.astonmartinsummitstagetest.util;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.model.User;

public class UserManager {

    private static final String USER_FILE_PATH = "src/test/resources/testData/userData.json";
    private static User user;

    public static User getUser(){
        if (user == null){
            user = UserParser.parseUserDataFromFileToUserObject(new User(), USER_FILE_PATH);
        }
        return user;
    }

//    public static String getFirstName(){
//        CustomLogger.info("UserManager.getFirstName()");
//        return getUser().getFirstName();
//    }
//
//    public static String getLastName(){
//        CustomLogger.info("UserManager.getSecondName()");
//        return getUser().getLastName();
//    }
//
//    public static String getPhone(){
//        CustomLogger.info("UserManager.getPhone()");
//        return getUser().getPhone();
//    }
//
//    public static String getEmail(){
//        CustomLogger.info("UserManager.getEmail()");
//        return getUser().getEmailAddress();
//    }
//
//    public static String getZipCode(){
//        CustomLogger.info("UserManager.getZipCode()");
//        return getUser().getZipCode();
//    }


}