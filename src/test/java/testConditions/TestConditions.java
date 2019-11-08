package testConditions;

import com.zendesk.coreFunctions.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestConditions extends DriverSetup {
    @BeforeClass
    public static void initializeTestBaseSetup() {
        String browserType = System.getProperty("browserType");

        try {
            DriverSetup.initDriver(URL, browserType);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Closing browser. ");
        driverInstance.quit();
        driverInstance = null;
    }
}