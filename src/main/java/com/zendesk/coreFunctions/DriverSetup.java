package com.zendesk.coreFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup extends GlobalDefinitions {
    protected static WebDriver driverInstance = null;

    public static void initDriver(String url, String browserType) {
        if (driverInstance == null) {
            switch (browserType) {
                case "chrome":
                    System.out.println("Launching Chrome driver with new profile...");
                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH + "chromedriver.exe");
                    driverInstance = new ChromeDriver();
                    break;
                    //here some other browser can be added easily

                default:
                    System.out.println("Invalid browser type specified. Please select chrome or firefox.");
            }

            driverInstance.manage().window().maximize();
            driverInstance.navigate().to(url);
        }
    }
}