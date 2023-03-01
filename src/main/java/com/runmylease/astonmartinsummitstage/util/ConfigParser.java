package com.runmylease.astonmartinsummitstage.util;

import com.runmylease.astonmartinsummitstage.model.Config;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigParser {

    public static Config parseConfigDataFromFileToConfigObject(Config config, String path) {
        CustomLogger.info("ConfigParser.parseConfigDataFromFileToConfigObject(Config config, String path)");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        config.setBrowserName((String)jsonObject.get("browserName"));
        config.setUrl((String)jsonObject.get("url"));
        config.setWaitDuration((String)jsonObject.get("waitDuration"));
        config.setOptions((String)jsonObject.get("options"));
        return config;
    }
}

