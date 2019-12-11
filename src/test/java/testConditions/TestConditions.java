package testConditions;

import com.zendesk.coreFunctions.DriverSetup;
import com.zendesk.utils.AllureEnvironment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.zendesk.coreFunctions.GlobalDefinitions.SITE_URL;

public class TestConditions extends AbstractTestNGSpringContextTests {

    @Autowired
    DriverSetup driverSetup;

    @BeforeClass
    public void initializeTestBaseSetup() {
        String browserType = System.getProperty("browserType").toLowerCase();

        try {
            driverSetup.initDriver(SITE_URL, browserType);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Closing browser. ");

        driverSetup.getDriverInstance().quit();
        driverSetup.setDriverInstance(null);

        AllureEnvironment.create();
    }
}