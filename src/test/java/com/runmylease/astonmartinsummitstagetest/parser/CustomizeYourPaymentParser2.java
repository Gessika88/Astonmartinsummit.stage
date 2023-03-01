package com.runmylease.astonmartinsummitstagetest.parser;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.model.CustomizeYourPayment;
import com.runmylease.astonmartinsummitstagetest.model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class CustomizeYourPaymentParser2 {

    public static CustomizeYourPayment parseCustomizeYourPaymentDataFromFileToUserObject(CustomizeYourPayment customizeYourPayment2, String path) {
        CustomLogger.info("parseCustomizeYourPaymentDataFromFileToUserObject(CustomizeYourPayment CustomizeYourPayment2, String path)");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customizeYourPayment2.setPrice((String)jsonObject.get("price"));
        customizeYourPayment2.setTerm((String)jsonObject.get("term"));
        customizeYourPayment2.setCreditScore((String)jsonObject.get("creditScore"));
        customizeYourPayment2.setInterestRate((String)jsonObject.get("interestRate"));
        customizeYourPayment2.setDownPayment((String)jsonObject.get("downPayment"));
        return customizeYourPayment2;
    }
}


