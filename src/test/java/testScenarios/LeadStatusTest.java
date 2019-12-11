package testScenarios;

import com.zendesk.userActions.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import testConditions.TestConditions;

@ContextConfiguration(classes = User.class)
public class LeadStatusTest extends TestConditions {
    private String firstName = RandomStringUtils.randomAlphabetic(4);
    private String lastName = RandomStringUtils.randomAlphabetic(4);
    private String newLeadStatusName = RandomStringUtils.randomAlphabetic(5);

    @Autowired
    User user;

    @Test
    public void leadStatusE2ETest() {
        user.logToZendeskWithCorrectCredentials();

        user.createAndViewNewLead(firstName, lastName);

        Assert.assertTrue(user.getCreatedLeadTitle().contains(firstName + " " + lastName));
        Assert.assertTrue(user.verifyIfLeadStatusCorrect(), "Incorrect Lead Status Displayed.");

        user.changeTheExistingLeadStatus(newLeadStatusName);
        Assert.assertTrue(user.verifyIfChangedLeadStatusCorrect(newLeadStatusName));

        user.changeTheExistingLeadStatus("New");
    }
}