package com.zendesk.coreFunctions;

import com.zendesk.utils.PropertiesReader;

public class GlobalDefinitions {
    public static final String SITE_URL = PropertiesReader.get("base.site.url");

    public static final int DELAY = 60;
    public static final int IMPLICITDELAY = 90;

    public static final String XPATH = "xpath";
    public static final String CSS = "css";

    public static final String LOGIN = System.getProperty("site.login");
    public static final String PASSWORD = System.getProperty("site.password");
}