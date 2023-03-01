package com.runmylease.astonmartinsummitstagetest.util;

import com.runmylease.astonmartinsummitstage.util.CustomLogger;
import com.runmylease.astonmartinsummitstagetest.model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class UserParser {

    public static User parseUserDataFromFileToUserObject(User user, String path) {
        CustomLogger.info("UserParser.parseUserDataFromFileToUserObject(User user, String path)");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setFirstName((String)jsonObject.get("firstName"));
        user.setLastName((String)jsonObject.get("lastName"));
        user.setPhone((String)jsonObject.get("phone"));
        user.setEmailAddress((String)jsonObject.get("emailAddress"));
        user.setZipCode((String)jsonObject.get("zipCode"));
        return user;
    }
}