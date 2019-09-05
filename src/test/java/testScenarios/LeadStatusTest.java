package testScenarios;

import com.zendesk.userActions.Login;
import com.zendesk.userActions.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import testConditions.TestConditions;

public class LeadStatusTest extends TestConditions {
    private String firstName = RandomStringUtils.randomAlphabetic(4);
    private String lastName = RandomStringUtils.randomAlphabetic(4);
    private String newLeadStatusName = RandomStringUtils.randomAlphabetic(5);

    @Test
    public void leadStatusTest() {
        Login.logWithCorrectTrialCredentials();
        User.createAndViewNewLead(firstName, lastName);

        Assert.assertTrue(User.getCreatedLeadTitle().contains(firstName + " " + lastName));
        Assert.assertTrue(User.verifyIfLeadStatusCorrect(), "Incorrect Lead Status Displayed.");

        User.changeTheExistingLeadStatus(newLeadStatusName);
        Assert.assertTrue(User.verifyIfChangedLeadStatusCorrect(newLeadStatusName));

        User.changeTheExistingLeadStatus("New");
    }
}