package com.runmylease.astonmartinsummitstagetest.parser;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.user.TodaysPrice;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class TodaysPriceParser {

    public static TodaysPrice parseTodaysPriceDataFromFileToUserObject(TodaysPrice todaysPrice, String path) {
        CustomLogger.info("parseTodaysPriceDataFromFileToUserObject(TodaysPrice todaysPrice, String path)");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        todaysPrice.setFirstName((String)jsonObject.get("firstName"));
        todaysPrice.setLastName((String)jsonObject.get("lastName"));
        todaysPrice.setPreferredContact((String)jsonObject.get("preferredContact"));
        todaysPrice.setPhone((String)jsonObject.get("phone"));
        todaysPrice.setEmailAddress((String)jsonObject.get("emailAddress"));
        todaysPrice.setComments((String)jsonObject.get("comments"));
        return todaysPrice;
    }
}


