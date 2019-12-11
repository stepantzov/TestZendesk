package com.zendesk.utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllureEnvironment {

    private static final Logger LOGGER = Logger.getLogger(AllureEnvironment.class.getName());

    public static void create() {
        String allureEnvironmentFilePath = System.getProperty("user.dir").concat(PropertiesReader.get("allure.environment.properties.file"));

        FileOutputStream outputStream = null;

        try {
            Properties allureProperties = new Properties();
            File file = new File(allureEnvironmentFilePath);
            file.createNewFile();

            outputStream = new FileOutputStream(file);

            Optional.ofNullable(System.getProperty("browserType")).ifPresent(s -> allureProperties.setProperty("Browser", s));
            Optional.ofNullable(System.getProperty("site.login")).ifPresent(s -> allureProperties.setProperty("Valid user: ", s));

            allureProperties.store(outputStream, "");
            outputStream.close();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IO problem when writing allure properties file", e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }
}