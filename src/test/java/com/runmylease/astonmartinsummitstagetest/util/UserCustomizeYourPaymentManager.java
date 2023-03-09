package com.runmylease.astonmartinsummitstagetest.util;

import com.runmylease.astonmartinsummitstagetest.user.CustomizeYourPayment;

public class UserCustomizeYourPaymentManager {

    private static final String USER_FILE_PATH = "src/test/resources/testData/userDataCustomizeYourPayment.json";
    private static CustomizeYourPayment user;

    public static CustomizeYourPayment getUser(){
        if (user == null){
            user = UserCustomizeYourPaymentParser.parseUserDataFromFileToUserObject(new CustomizeYourPayment(), USER_FILE_PATH);
        }
        return user;
    }

}