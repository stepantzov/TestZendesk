package testConditions;

import com.zendesk.coreFunctions.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestConditions extends DriverSetup {
    @BeforeClass
    @Parameters("browserType")
    public static void initializeTestBaseSetup(String browserType) {
        try {
            DriverSetup.initDriver(URL, browserType);
        } catch (Exception e) {
            System.out.println("Error....." + e.getLocalizedMessage());
        }
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Closing browser. ");
        driverInstance.quit();
        driverInstance = null;
    }
}