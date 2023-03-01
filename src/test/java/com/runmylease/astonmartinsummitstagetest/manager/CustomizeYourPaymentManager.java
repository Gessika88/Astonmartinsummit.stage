package com.runmylease.astonmartinsummitstagetest.manager;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.model.CustomizeYourPayment;
import com.runmylease.astonmartinsummitstagetest.parser.CustomizeYourPaymentParser;

import java.util.ArrayList;
import java.util.List;

public class CustomizeYourPaymentManager {

    private static final String CUSTOMIZE_YOUR_PAYMENT_FILE_PATH = "src/test/resources/testData/customizeYourPaymentPopUp.json";
    private static CustomizeYourPayment customizeYourPayment;

    public static CustomizeYourPayment getCustomizeYourPayment(){
        if (customizeYourPayment == null){
            customizeYourPayment = CustomizeYourPaymentParser.parseCustomizeYourPaymentDataFromFileToUserObject(new CustomizeYourPayment(), CUSTOMIZE_YOUR_PAYMENT_FILE_PATH);
        }
        return customizeYourPayment;
    }

    public static String getFirstName(){
        CustomLogger.info("CustomizeYourPaymentManager.getFirstName()");
        return getCustomizeYourPayment().getFirstName();
    }

    public static String getLastName(){
        CustomLogger.info("CustomizeYourPaymentManager.getSecondName()");
        return getCustomizeYourPayment().getLastName();
    }

    public static String getPreferredContact(){
        CustomLogger.info("CustomizeYourPaymentManager.getPreferredContact()");
        return getCustomizeYourPayment().getPreferredContact();
    }

    public static String getPhone(){
        CustomLogger.info("CustomizeYourPaymentManager.getPhone()");
        return getCustomizeYourPayment().getPhone();
    }

    public static String getEmail(){
        CustomLogger.info("CustomizeYourPaymentManager.getEmail()");
        return getCustomizeYourPayment().getEmailAddress();
    }

    public static String getZipCode(){
        CustomLogger.info("CustomizeYourPaymentManager.getZipCode()");
        return getCustomizeYourPayment().getZipCode();
    }

    public static List <String> getCustomizeYourPaymentExpectedList(){
        List customizeYourPaymentExpectedList = new ArrayList<>();
        customizeYourPaymentExpectedList.add(getFirstName());
        customizeYourPaymentExpectedList.add(getLastName());
        customizeYourPaymentExpectedList.add(getPreferredContact());
        customizeYourPaymentExpectedList.add(getPhone());
        customizeYourPaymentExpectedList.add(getEmail());
        customizeYourPaymentExpectedList.add(getZipCode());
        return customizeYourPaymentExpectedList;
    }


}
