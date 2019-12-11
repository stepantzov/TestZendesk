package com.zendesk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public static String get(String propertyName) {
        String propertyValue = null;
        Properties properties = new Properties();
        InputStream input;

        try {
            input = PropertiesReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                System.out.println("Unable to find config file.");
            }
            properties.load(input);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return propertyValue;
    }
}