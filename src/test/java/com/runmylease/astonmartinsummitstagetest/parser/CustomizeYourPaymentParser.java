package com.runmylease.astonmartinsummitstagetest.parser;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.model.CustomizeYourPayment;
import com.runmylease.astonmartinsummitstagetest.model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class CustomizeYourPaymentParser {

    public static CustomizeYourPayment parseCustomizeYourPaymentDataFromFileToUserObject(CustomizeYourPayment customizeYourPayment, String path) {
        CustomLogger.info("parseCustomizeYourPaymentDataFromFileToUserObject(CustomizeYourPayment CustomizeYourPayment, String path)");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customizeYourPayment.setFirstName((String)jsonObject.get("firstName"));
        customizeYourPayment.setLastName((String)jsonObject.get("lastName"));
        customizeYourPayment.setPreferredContact((String)jsonObject.get("preferredContact"));
        customizeYourPayment.setPhone((String)jsonObject.get("phone"));
        customizeYourPayment.setEmailAddress((String)jsonObject.get("emailAddress"));
        customizeYourPayment.setZipCode((String)jsonObject.get("zipCode"));
        return customizeYourPayment;
    }
}

