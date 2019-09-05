package com.zendesk.coreFunctions;

import com.zendesk.utils.Properties;

public class GlobalDefinitions {
    protected static final String CHROME_DRIVER_PATH = System.getProperty("user.dir").concat("\\drivers\\chromeDriver\\");

    protected static final String URL = Properties.get("base.site.url");

    protected static final int DELAY = 60;
    protected static final int IMPLICITDELAY = 90;

    protected static final String XPATH = "xpath";
    protected static final String CSS = "css";

    protected static final String LOGIN = "stepantzov@gmail.com";
    protected static final String PASSWORD = "123ZZrorZ";
}