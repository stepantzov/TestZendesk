package com.zendesk.coreFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverSetup {
    private static WebDriver driverInstance = null;

    public static void initDriver(String url, String browserType) {
        if (driverInstance == null) {
            switch (browserType) {
                case "chrome":
                    System.out.println("Launching Chrome driver with new profile.");

                    WebDriverManager.chromedriver().setup();

                    driverInstance = new ChromeDriver();
                    break;

                case "firefox":
                    System.out.println("Launching Firefox driver with new profile.");

                    WebDriverManager.firefoxdriver().setup();

                    driverInstance = new FirefoxDriver();
                    break;

                case "explorer":
                    System.out.println("Launching Explorer driver with new profile.");

                    WebDriverManager.iedriver().setup();

                    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                    caps.setCapability("ignoreZoomSetting", true);
                    driverInstance = new InternetExplorerDriver(caps);

                    break;

                case "phantomjs":
                    System.out.println("Launching PhantomJSDriver driver.");

                    WebDriverManager.phantomjs().setup();

                    driverInstance = new PhantomJSDriver();
                    break;

                default:
                    System.out.println("Invalid browser type specified.");
            }

            driverInstance.manage().window().maximize();
            driverInstance.navigate().to(url);
        }
    }

    public WebDriver getDriverInstance() {
        return driverInstance;
    }

    public void setDriverInstance(WebDriver driverInstance) {
        this.driverInstance = driverInstance;
    }
}