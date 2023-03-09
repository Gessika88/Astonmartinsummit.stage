package com.runmylease.astonmartinsummitstagetest.manager;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.user.CustomizeYourPayment;
import com.runmylease.astonmartinsummitstagetest.parser.CustomizeYourPaymentParser2;

import java.util.ArrayList;
import java.util.List;

public class CustomizeYourPaymentManager2 {

    private static final String CUSTOMIZE_YOUR_PAYMENT2_FILE_PATH = "src/test/resources/testData/customizeYourPaymentPopUp2.json";
    private static CustomizeYourPayment customizeYourPayment2;

    public static CustomizeYourPayment getCustomizeYourPayment2(){
        if (customizeYourPayment2 == null){
            customizeYourPayment2 = CustomizeYourPaymentParser2.parseCustomizeYourPaymentDataFromFileToUserObject(new CustomizeYourPayment(), CUSTOMIZE_YOUR_PAYMENT2_FILE_PATH);
        }
        return customizeYourPayment2;
    }

    public static String getPrice(){
        CustomLogger.info("CustomizeYourPaymentManager2.getPrice()");
        return getCustomizeYourPayment2().getPrice();
    }

    public static String getTerm(){
        CustomLogger.info("CustomizeYourPaymentManager2.getTerm()");
        return getCustomizeYourPayment2().getTerm();
    }

    public static String getCreditScore(){
        CustomLogger.info("CustomizeYourPaymentManager2.getCreditScore()");
        return getCustomizeYourPayment2().getCreditScore();
    }

    public static String getInterestRate(){
        CustomLogger.info("CustomizeYourPaymentManager2.getInterestRate()");
        return getCustomizeYourPayment2().getInterestRate();
    }

    public static String getDownPayment(){
        CustomLogger.info("CustomizeYourPaymentManager2.getDownPayment()");
        return getCustomizeYourPayment2().getDownPayment();
    }

    public static List <String> getCustomizeYourPaymentExpected2List(){
        List customizeYourPaymentExpected2List = new ArrayList<>();
        customizeYourPaymentExpected2List.add(getPrice());
        customizeYourPaymentExpected2List.add(getTerm());
        customizeYourPaymentExpected2List.add(getCreditScore());
        customizeYourPaymentExpected2List.add(getInterestRate());
        customizeYourPaymentExpected2List.add(getDownPayment());
        return customizeYourPaymentExpected2List;
    }


}

