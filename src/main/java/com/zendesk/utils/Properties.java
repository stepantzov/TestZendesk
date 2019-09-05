package com.zendesk.utils;

import java.io.IOException;
import java.io.InputStream;

public class Properties {
    public static String get(String propertyName) {
        String propertyValue = null;
        java.util.Properties properties = new java.util.Properties();
        InputStream input;
        try {
            input = Properties.class.getClassLoader().getResourceAsStream("config.properties");
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